package br.com.collei.lavi.api.resource;

import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.time.DateFormatUtils;

import br.com.collei.lavi.api.swagger.Meta;
import br.com.collei.lavi.api.util.DatePatterns;

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
}
