package br.net.heaven.projects.api.swagger.declensions;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.morphology.EnumNounCases;
import br.com.collei.lavi.morphology.EnumNounPluralities;
import br.net.heaven.projects.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NounDeclensedCaseForm {

	@Schema(example = "havat", required = true, description = "Substantivo na forma de caso declinada.")
	@JsonProperty("declensed")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 60)
	private String declensed;
	
	@Schema(example = "ACCUSATIVE", required = true, description = "Caso no qual a forma se encontra declinada.")
	@JsonProperty("case")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 12)
	private EnumNounCases nounCase;
	
	@Schema(example = "SINGULAR", required = true, description = "Pluralidade na qual a forma de caso está declinada.")
	@JsonProperty("plurality")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 8)
	private EnumNounPluralities plurality;

}
