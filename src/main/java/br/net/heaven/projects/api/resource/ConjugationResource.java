package br.net.heaven.projects.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.net.heaven.projects.api.service.ConjugationService;
import br.net.heaven.projects.api.swagger.ResponseError;
import br.net.heaven.projects.api.swagger.ResponseVerbConjugationTableData;

@Path("/verbs")
public class ConjugationResource {
	
	@Inject
	ConjugationService service;

	@Path("{verb}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Tabela de conjugação do verbo especificado", description = "Método para obter a tabela de conjugação do verbo solicitado")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Verbo com sua tabela de conjugação.", content = @Content(schema = @Schema(implementation = ResponseVerbConjugationTableData.class))),
		@APIResponse(responseCode = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "401", description = "Cabeçalho de autenticação ausente/inválido ou token inválido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "403", description = "O token tem escopo incorreto ou uma política de segurança foi violada", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "404", description = "O recurso solicitado não existe ou não foi implementado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "405", description = "O consumidor tentou acessar o recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "406", description = "A solicitação continha um cabeçalho Accept diferente dos tipos de mídia permitidos ou um conjunto de caracteres diferente de UTF-8", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "429", description = "A operação foi recusada, pois muitas solicitações foram feitas dentro de um determinado período ou o limite global de requisições concorrentes foi atingido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "200", description = "Tabela de conjugação do verbo especificado", content = @Content(schema = @Schema(implementation = ResponseVerbConjugationTableData.class)))
    })
	public Response conjugar(@PathParam("verb") @Parameter(description="Verbo a ser conjugado.", required=true) String verb, @QueryParam("filters") @Parameter(description="Lista de critérios, separados por vírgula, que deverão ser retornados.") String filters) {
		System.out.println("\r\n--- Verbo: '" + verb + "'\r\n--- Filtros: " + (filters!=null ? filters : "") + "\r\n");
		ResponseVerbConjugationTableData verbo;
		//
		if (filters != null && !"".equals(filters)) {
			verbo = service.findConjugationTableFiltered(verb, List.of(filters.split(",")));
		} else {
			verbo = service.findConjugationTable(verb);
		}
		//	
		return  Response.ok(verbo, MediaType.APPLICATION_JSON).header("x-v", ResourceConstants.VERSION).build();
	}	

}
