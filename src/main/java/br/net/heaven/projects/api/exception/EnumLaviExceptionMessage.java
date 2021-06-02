package br.net.heaven.projects.api.exception;

import java.util.Objects;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumLaviExceptionMessage {
	
	BAD_REQUEST("400", "Bad Request", "Solicitação malformada. verifique se esqueceu de incluir algum atributo obrigatório."),
	UNAUTHORIZED("401", "Unauthorized", "Cabeçalho de autorização ausente ou token inválido."),
	FORBIDDEN("403", "Forbidden", "Operação não autorizada ou fora do escopo do token."),
	NOT_FOUND("404", "Not Found", "O verbete não foi encontrado no dicionário."),
	METHOD_NOT_ALLOWED("405", "Method Not Allowed", "Método não suportado para este Endpoint."),
	NOT_ACCEPTABLE("406", "Not Acceptable", "Solicitação com cabeçalho Accept não suportado pelo Endpoint"),
	GONE("410", "Gone", "Conteúdo não mais disponível."),
	UNSUPPORTED_MEDIA_TYPE("415", "Unsupported Media Type", "Solicitação recusada por estar fora do formato aceito pelo Endpoint."),
	UNPROCESSABLE_ENTITY("422", "Unprocessable Entity", "Solicitação impossível de processar de acordo com a lógica do negócio."),
	TOO_MANY_REQUESTS("429", "Too Many Requests", "Número de solicitações elevado, acima da capacidade do servidor."),
	INTERNAL_SERVER_ERROR("500", "Internal Server Error", "Ocorreu um erro no gateway da API ou do microsserviço."),
	SERVICE_UNAVAILABLE("503", "Service Unavailable", "Serviço indisponível no momento."),
	GATEWAY_TIMEOUT("504", "Gateway Timeout", "O servidor não pôde responder em tempo hábil.");
	
	private String code;
	private String title;
	private String detail;
	
	public static EnumLaviExceptionMessage getByCode(Object code) {
		return Stream
				.of(EnumLaviExceptionMessage.values())
				.filter(e -> e.getCode().equals(Objects.toString(code, "")))
				.findFirst()
				.orElse(null);
	}
	

}
