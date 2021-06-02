package br.net.heaven.projects.api.resource;

import java.util.Date;
import java.util.Optional;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.lang3.time.DateFormatUtils;

import br.net.heaven.projects.api.swagger.Meta;
import br.net.heaven.projects.api.util.DatePatterns;

public class ResourceData {
    public static Meta createMeta() {
        return Meta.builder()
            .requestDateTime(DateFormatUtils.format(new Date(), DatePatterns.EEE_MMM_d_HH_mm_ss_zzz_yyyy))
            .build();
    }

    public static Response createDefaultResponse(Object entity) {
        return Response
        	.ok(entity, MediaType.APPLICATION_JSON)
        	.header("x-v", ResourceConstants.VERSION)
        	.build();
    }
    
    public static Response okResponse(Object entity, Optional<String> interactionId) {
    	ResponseBuilder responseBuilder = Response.ok(entity, MediaType.APPLICATION_JSON).header("machine-type", "Character");
    	interactionId.ifPresent(w -> responseBuilder.header("x-interaction-id", w));
    	return responseBuilder.build();
    }
    
}
