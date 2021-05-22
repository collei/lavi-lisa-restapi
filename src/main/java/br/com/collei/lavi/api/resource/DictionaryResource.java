package br.com.collei.lavi.api.resource;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.com.collei.lavi.api.exception.EnumLaviExceptionMessage;
import br.com.collei.lavi.api.exception.LaviException;
import br.com.collei.lavi.api.service.DictionaryService;
import br.com.collei.lavi.api.swagger.ResponseDictionaryEntryInfoData;
import br.com.collei.lavi.api.swagger.ResponseDictionaryMeaningInfoData;
import br.com.collei.lavi.api.swagger.ResponseDictionaryPartsOfSpeechData;
import br.com.collei.lavi.api.swagger.ResponseError;

@Path("/dic")
public class DictionaryResource {
	
	@Inject
	DictionaryService service;

	@Path("entries/lavi/{entry}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Informações da entrada de dicionário pesquisada.", description = "Método para obter os significados da entrada pesquisada")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "A entrada pesquisada.", content = @Content(schema = @Schema(implementation = ResponseDictionaryEntryInfoData.class))),
		@APIResponse(responseCode = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "401", description = "Cabeçalho de autenticação ausente/inválido ou token inválido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "403", description = "O token tem escopo incorreto ou uma política de segurança foi violada", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "404", description = "O recurso solicitado não existe ou não foi implementado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "405", description = "O consumidor tentou acessar o recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "406", description = "A solicitação continha um cabeçalho Accept diferente dos tipos de mídia permitidos ou um conjunto de caracteres diferente de UTF-8", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "429", description = "A operação foi recusada, pois muitas solicitações foram feitas dentro de um determinado período ou o limite global de requisições concorrentes foi atingido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "200", description = "A entrada pesquisada.", content = @Content(schema = @Schema(implementation = ResponseDictionaryEntryInfoData.class)))
    })
	public Response pesquisarLavi(@PathParam("entry") @Parameter(description="Entrada de dicionário a ser pesquisada.", required=true) String entry) throws LaviException {
		System.out.println("\r\n--- Entrada pesquisada: '" + entry + "'\r\n");
		Optional<ResponseDictionaryEntryInfoData> entrada;
		entrada = service.findEntryInfo(entry);
		if (entrada.isEmpty()) {
			throw new LaviException(EnumLaviExceptionMessage.NOT_FOUND);
		}
		return Response.ok(entrada, MediaType.APPLICATION_JSON).header("x-v", ResourceConstants.VERSION).build();
	}	

	@Path("entries/portuguese/{meaning}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Informações das entradas de dicionário correspondentes pesquisadas.", description = "Informações das entradas de dicionário pesquisadas que correspondam à palavra ou expressão em português.")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "As entradas que correspondem à palavra ou expressão em Português pesquisada.", content = @Content(schema = @Schema(implementation = ResponseDictionaryMeaningInfoData.class))),
		@APIResponse(responseCode = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "401", description = "Cabeçalho de autenticação ausente/inválido ou token inválido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "403", description = "O token tem escopo incorreto ou uma política de segurança foi violada", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "404", description = "O recurso solicitado não existe ou não foi implementado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "405", description = "O consumidor tentou acessar o recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "406", description = "A solicitação continha um cabeçalho Accept diferente dos tipos de mídia permitidos ou um conjunto de caracteres diferente de UTF-8", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "429", description = "A operação foi recusada, pois muitas solicitações foram feitas dentro de um determinado período ou o limite global de requisições concorrentes foi atingido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "200", description = "As entradas que correspondem à palavra ou expressão em Português pesquisada", content = @Content(schema = @Schema(implementation = ResponseDictionaryMeaningInfoData.class)))
    })
	public Response pesquisarPortugues(@PathParam("meaning") @Parameter(description="Significado a ser pesquisado.", required=true) String meaning) throws LaviException {
		System.out.println("\r\n--- Correspondência pesquisada: '" + meaning + "'\r\n");
		Optional<ResponseDictionaryMeaningInfoData> lista;
		lista = service.findMeaningInfo(meaning);
		if (lista.isEmpty()) {
			throw new LaviException(EnumLaviExceptionMessage.NOT_FOUND);
		}
		return Response.ok(lista, MediaType.APPLICATION_JSON).header("x-v", ResourceConstants.VERSION).build();
	}	

	@Path("parts-of-speech")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Lista de classes gramaticais suportadas pelo dicionário.", description = "Método para obter a lista de classes gramaticais suportadas.")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Lista de classes gramaticais suportadas pelo dicionário.", content = @Content(schema = @Schema(implementation = ResponseDictionaryPartsOfSpeechData.class))),
		@APIResponse(responseCode = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "401", description = "Cabeçalho de autenticação ausente/inválido ou token inválido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "403", description = "O token tem escopo incorreto ou uma política de segurança foi violada", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "404", description = "O recurso solicitado não existe ou não foi implementado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "405", description = "O consumidor tentou acessar o recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "406", description = "A solicitação continha um cabeçalho Accept diferente dos tipos de mídia permitidos ou um conjunto de caracteres diferente de UTF-8", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "429", description = "A operação foi recusada, pois muitas solicitações foram feitas dentro de um determinado período ou o limite global de requisições concorrentes foi atingido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "200", description = "Lista de classes gramaticais suportadas pelo dicionário.", content = @Content(schema = @Schema(implementation = ResponseDictionaryPartsOfSpeechData.class)))
    })
	public Response listarClassesGramaticais() {
		ResponseDictionaryPartsOfSpeechData classesGramaticais;
		classesGramaticais = service.listPartsofSpeech();
		return Response.ok(classesGramaticais, MediaType.APPLICATION_JSON).header("x-v", ResourceConstants.VERSION).build();
	}	

}
