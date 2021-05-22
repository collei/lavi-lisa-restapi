package br.com.collei.lavi.api.swagger.dictionary;

import java.util.List;

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
public class DictionaryPartsOfSpeechListInfo {

	@Schema(example = "1", required = true, description = "Número de classes gramaticais listadas.")
	@JsonProperty("count")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	private long count;
	
	@Schema(required = true, description = "Lista das classes gramaticais.")
	@JsonProperty("partsOfSpeech")
	@NotNull
	@Size(min = 1)
	private List<DictionaryPartOfSpeechInfo> partsOfSpeech;	
	
}
