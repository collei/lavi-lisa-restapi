package br.com.collei.lavi.api.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class LaviExceptionHandler implements ExceptionMapper<LaviException> {

	@Override
	public Response toResponse(LaviException exception) {
		return LaviException.laviExceptionResponseBuilder(exception);
	}

}
