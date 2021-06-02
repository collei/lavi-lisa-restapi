package br.net.heaven.projects.api.swagger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.net.heaven.projects.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Metainformações referentes a API requisitada.")
public class Meta {

//	@Schema(example = "1", required = true, description = "Número total de registros no resultado")
//	@JsonProperty("totalRecords")
//	@NotNull
//	private Integer totalRecords;
//
//	@Schema(example = "1", required = true, description = "Número total de páginas no resultado")
//	@JsonProperty("totalPages")
//	@NotNull
//	private Integer totalPages;

	@Schema(example = "2020-07-21T08:30:00Z", required = true, description = "Data e hora da consulta, conforme especificação RFC-3339, formato UTC.")
	@JsonProperty("requestDateTime")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.RFC3339_DATE_FORMAT)
	@Size(max = 20)
	private String requestDateTime;

}

