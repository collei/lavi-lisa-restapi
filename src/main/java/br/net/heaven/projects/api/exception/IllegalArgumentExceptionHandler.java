package br.net.heaven.projects.api.exception;


import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.contains;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class IllegalArgumentExceptionHandler implements ExceptionMapper<IllegalArgumentException> {

	@Override
	public Response toResponse(IllegalArgumentException exception) {
		return LaviException.laviExceptionResponseBuilder(
					ofNullable(exception)
						.filter(e -> {
							log.error(e.getMessage(), e);
							return contains(e.getMessage(), "RESTEASYGIYANFEI");
						})
						.map(e -> EnumLaviExceptionMessage.NOT_ACCEPTABLE)
						.orElse(EnumLaviExceptionMessage.INTERNAL_SERVER_ERROR)
		);
	}

}
