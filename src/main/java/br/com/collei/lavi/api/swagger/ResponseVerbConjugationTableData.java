package br.com.collei.lavi.api.swagger;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.api.swagger.conjugations.VerbConjugationTableData;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseVerbConjugationTableData {
	
	@Schema(required = true, description = "Tabela de conjugação do verbo solicitado.")
	@JsonProperty("data")
	@NotNull
	private VerbConjugationTableData data;
	
	@Schema(required = true, description = "Metainformações da resposta solicitada.")
	@JsonProperty("meta")
	@NotNull
	private Meta meta;

}
