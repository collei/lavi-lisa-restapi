package br.com.collei.lavi.api.swagger.dictionary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.api.model.DictionaryPartOfSpeechEnum;
import br.com.collei.lavi.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DictionaryPartOfSpeechInfo {

	@Schema(example = "Noun", required = true, description = "Nome da classe gramatical.")
	@JsonProperty("partOfSpeech")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 16)
	private String partOfSpeech;
	
	@Schema(example = "1", required = true, description = "Nome da classe gramatical.")
	@JsonProperty("partOfSpeechId")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	private long partOfSpeechId;
	
	@Schema(example = "n.", required = true, description = "Forma de abreviatura da classe gramatical.")
	@JsonProperty("abbreviatedForm")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 8)
	private String abbreviatedForm;
	
	@Schema(example = "NOUN", required = true, description = "Código interno da classe gramatical.")
	@JsonProperty("partOfSpeechCode")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 16)
	private DictionaryPartOfSpeechEnum partOfSpeechCode;

}
