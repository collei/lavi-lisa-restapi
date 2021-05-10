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
public class DictionaryEntryInfo {
	
	@Schema(example = "eda", required = true, description = "Entrada pesquisada.")
	@JsonProperty("entry")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 45)
	private String entry;
	
	@Schema(required = true, description = "Lista de detalhes relacionados à entrada pesquisada.")
	@JsonProperty("entryDetails")
	@NotNull
	@Size(min = 1)
	private List<DictionaryEntryDetailedInfo> entryDetails;	
	
}
