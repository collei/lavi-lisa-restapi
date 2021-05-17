package br.com.collei.lavi.api.exception;


import static java.util.Optional.ofNullable;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class NullPointerExceptionHandler implements ExceptionMapper<NullPointerException> {

	@Override
	public Response toResponse(NullPointerException exception) {
		ofNullable(exception).ifPresent(e -> log.error(e.getMessage(), e));
		return LaviException.laviExceptionResponseBuilder(EnumLaviExceptionMessage.INTERNAL_SERVER_ERROR);
	}

}
