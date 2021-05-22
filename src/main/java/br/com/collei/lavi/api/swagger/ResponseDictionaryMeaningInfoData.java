package br.com.collei.lavi.api.swagger;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.api.swagger.dictionary.DictionaryMeaningInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDictionaryMeaningInfoData {

	@Schema(required = true, description = "Lista de Informações das entradas correspondentes ao significado pesquisado.")
	@JsonProperty("data")
	@NotNull
	private DictionaryMeaningInfo data;

	@Schema(required = true, description = "Metainformações da resposta solicitada.")
	@JsonProperty("meta")
	@NotNull
	private Meta meta;
	
}
