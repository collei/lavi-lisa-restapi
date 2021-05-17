package br.com.collei.lavi.api.exception;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.exception.ExceptionUtils.throwableOfType;

import javax.ws.rs.core.Response;

import org.apache.commons.lang.math.NumberUtils;

import br.com.collei.lavi.api.resource.ResourceData;
import br.com.collei.lavi.api.swagger.ResponseError;
import br.com.collei.lavi.api.swagger.ResponseErrorErrors;
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
