package br.net.heaven.projects.api.swagger;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.net.heaven.projects.api.swagger.dictionary.DictionaryEntryInfo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDictionaryEntryInfoData {

	@Schema(required = true, description = "Informações da entrada pesquisada.")
	@JsonProperty("data")
	@NotNull
	private DictionaryEntryInfo data;

	@Schema(required = true, description = "Metainformações da resposta solicitada.")
	@JsonProperty("meta")
	@NotNull
	private Meta meta;
	
}
