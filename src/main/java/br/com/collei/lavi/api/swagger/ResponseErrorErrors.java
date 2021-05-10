package br.com.collei.lavi.api.swagger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseErrorErrors {

	@Schema(required = true, description = "Código de erro específico do endpoint")
	@JsonProperty("code")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 140)
	private String code;

	@Schema(required = true, description = "Título legível por humanos do erro deste erro específico")
	@JsonProperty("title")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 140)
	private String title;

	@Schema(required = true, description = "Descrição legível por humanos deste erro específico")
	@JsonProperty("detail")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 2048)
	private String detail;

}