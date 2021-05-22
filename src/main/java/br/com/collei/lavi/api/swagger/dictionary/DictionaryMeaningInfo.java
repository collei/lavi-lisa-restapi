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
public class DictionaryMeaningInfo {
	
	@Schema(example = "significado", required = true, description = "Significado pesquisado.")
	@JsonProperty("meaning")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 45)
	private String meaning;
	
	@Schema(example = "1", required = true, description = "Número de entradas na lista.")
	@JsonProperty("count")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	private int count;
	
	@Schema(required = true, description = "Lista de entradas com os respectivos detalhes inclusos.")
	@JsonProperty("details")
	@NotNull
	@Size(min = 1)
	private List<DictionaryEntryInfo> details;	
	
}
