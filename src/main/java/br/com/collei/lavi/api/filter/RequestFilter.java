package br.com.collei.lavi.api.filter;

import static java.util.Optional.ofNullable;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RequestFilter implements ContainerRequestFilter {

	private static final List<String> CONTENT_TYPE_REQUIRED_METHODS = List.of(HttpMethod.GET);
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		ofNullable(requestContext.getMediaType())
			.filter(mediaType -> CONTENT_TYPE_REQUIRED_METHODS.contains(requestContext.getMethod()) && !MediaType.APPLICATION_JSON_TYPE.getSubtype().equalsIgnoreCase(mediaType.getSubtype()))
			.ifPresent(mediaType -> requestContext.abortWith(Response.status(Status.NOT_ACCEPTABLE).build()));
	}

}
