package br.net.heaven.projects.api.exception;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.exception.ExceptionUtils.throwableOfType;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.math.NumberUtils;

import br.net.heaven.projects.api.resource.ResourceData;
import br.net.heaven.projects.api.swagger.ResponseError;
import br.net.heaven.projects.api.swagger.ResponseErrorErrors;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class LaviException extends Exception {
	
	private static final long serialVersionUID = 115884231123289L;
	
	private EnumLaviExceptionMessage statusMessage;
	
	public LaviException(EnumLaviExceptionMessage statusMessage) {
		super(statusMessage.getTitle());
		this.statusMessage = statusMessage;
	}
	
	public static Response laviExceptionResponseBuilder(LaviException le) {
		return laviExceptionResponseBuilder(le.getStatusMessage());
	}
	
	public static Response laviExceptionResponseBuilder(EnumLaviExceptionMessage elemsg) {
		return Response.status(NumberUtils.toInt(elemsg.getCode())).entity(buildErrorBody(elemsg)).build();
	}

	public static ResponseError buildErrorBody(EnumLaviExceptionMessage elemsg) {
		return ResponseError.builder()
				.errors(List.of(ResponseErrorErrors.builder().code(elemsg.getCode()).title(elemsg.getTitle()).detail(elemsg.getDetail()).build()))
				.meta(ResourceData.createMeta())
				.build();
	}
	
	public static LaviException of(Throwable e) {
		return ofNullable(throwableOfType(e, LaviException.class)).orElse(new LaviException(EnumLaviExceptionMessage.INTERNAL_SERVER_ERROR));
	}	

}
