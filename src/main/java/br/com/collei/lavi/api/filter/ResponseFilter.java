package br.com.collei.lavi.api.filter;

import java.io.IOException;
import java.util.Optional;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import br.com.collei.lavi.api.exception.EnumLaviExceptionMessage;
import br.com.collei.lavi.api.exception.LaviException;

@Provider
public class ResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		Optional.ofNullable(EnumLaviExceptionMessage.getByCode(responseContext.getStatus())).ifPresent((e) -> buildErrorResponse(responseContext, e));
	}

	private void buildErrorResponse(ContainerResponseContext responseContext, EnumLaviExceptionMessage exceptionEnum) {
		responseContext.setEntity(LaviException.buildErrorBody(exceptionEnum), responseContext.getEntityAnnotations(), MediaType.APPLICATION_JSON_TYPE);
	}

}
