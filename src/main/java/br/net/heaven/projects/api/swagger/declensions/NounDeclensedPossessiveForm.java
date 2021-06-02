package br.net.heaven.projects.api.swagger.declensions;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.morphology.EnumNounPersons;
import br.com.collei.lavi.morphology.EnumNounPluralities;
import br.net.heaven.projects.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NounDeclensedPossessiveForm {

	@Schema(example = "havat", required = true, description = "Substantivo na forma possessiva indicada.")
	@JsonProperty("declensed")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 60)
	private String declensed;
	
	@Schema(example = "I", required = true, description = "Pessoa na qual a forma possessiva se encontra declinada.")
	@JsonProperty("person")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 10)
	private EnumNounPersons person;
	
	@Schema(example = "SINGULAR", required = true, description = "Pluralidade na qual a forma possessiva se encontra declinada.")
	@JsonProperty("plurality")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 8)
	private EnumNounPluralities plurality;
	
}
