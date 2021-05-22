package br.com.collei.lavi.api.swagger;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.api.swagger.dictionary.DictionaryPartsOfSpeechListInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDictionaryPartsOfSpeechData {

	@Schema(required = true, description = "Informações da lista de classes gramaticais.")
	@JsonProperty("data")
	@NotNull
	private DictionaryPartsOfSpeechListInfo data;

	@Schema(required = true, description = "Metainformações da resposta solicitada.")
	@JsonProperty("meta")
	@NotNull
	private Meta meta;

}
