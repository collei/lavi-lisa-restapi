package br.net.heaven.projects.api.swagger;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseError   {

	@Schema(required = true, description = "Lista dos erros gerados.")
	@JsonProperty("errors")
	@NotNull
	@Size(min=1,max=13)
	private List<ResponseErrorErrors> errors;

	@Schema(description = "Metainformações da API")
	@JsonProperty("meta")
	private Meta meta;

}
