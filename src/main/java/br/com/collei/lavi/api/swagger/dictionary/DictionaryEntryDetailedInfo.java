package br.com.collei.lavi.api.swagger.dictionary;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.api.model.DictionaryPartOfSpeechEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DictionaryEntryDetailedInfo {

	@Schema(required = true, description = "Classe gramatical da entrada pesquisada.")
	@JsonProperty("partOfSpeech")
	@NotNull
	@Size(max = 16)
	private DictionaryPartOfSpeechEnum partOfSpeech;	
	
	@Schema(required = true, description = "Lista de significados relacionados à entrada pesquisada.")
	@JsonProperty("meanings")
	@NotNull
	@Size(min = 1)
	private List<String> meanings;	

}
