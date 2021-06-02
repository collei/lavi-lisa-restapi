package br.net.heaven.projects.api.resource;

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

import br.net.heaven.projects.api.service.DeclensionService;
import br.net.heaven.projects.api.swagger.ResponseError;
import br.net.heaven.projects.api.swagger.ResponseNounDeclensionTableData;

@Path("/nouns")
public class DeclensionResource {
	
	@Inject
	DeclensionService service;

	@Path("{noun}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(summary = "Tabela de declinação do susbtantivo especificado", description = "Método para obter a tabela de declinação do nome, substantivo ou pronome especificado.")
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Substantivo com sua tabela de declinação.", content = @Content(schema = @Schema(implementation = ResponseNounDeclensionTableData.class))),
		@APIResponse(responseCode = "400", description = "A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL.", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "401", description = "Cabeçalho de autenticação ausente/inválido ou token inválido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "403", description = "O token tem escopo incorreto ou uma política de segurança foi violada", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "404", description = "O recurso solicitado não existe ou não foi implementado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "405", description = "O consumidor tentou acessar o recurso com um método não suportado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "406", description = "A solicitação continha um cabeçalho Accept diferente dos tipos de mídia permitidos ou um conjunto de caracteres diferente de UTF-8", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "429", description = "A operação foi recusada, pois muitas solicitações foram feitas dentro de um determinado período ou o limite global de requisições concorrentes foi atingido", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "500", description = "Ocorreu um erro no gateway da API ou no microsserviço", content = @Content(schema = @Schema(implementation = ResponseError.class))),
		@APIResponse(responseCode = "200", description = "Substantivo com sua tabela de declinação", content = @Content(schema = @Schema(implementation = ResponseNounDeclensionTableData.class)))
    })
	public Response declinar(@PathParam("noun") @Parameter(description="Substantivo, nome ou pronome a ser declinado.", required=true) String noun) {
		System.out.println("\r\n--- Substantivo: '" + noun + "'\r\n");
		ResponseNounDeclensionTableData substantivo;
		substantivo = service.findDeclensionTable(noun);
		return  Response.ok(substantivo, MediaType.APPLICATION_JSON).header("x-v", ResourceConstants.VERSION).build();
	}	

}
