package br.net.heaven.projects.api.swagger.conjugations;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.collei.lavi.morphology.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.EnumVerbModes;
import br.com.collei.lavi.morphology.EnumVerbPersons;
import br.com.collei.lavi.morphology.EnumVerbTenses;
import br.com.collei.lavi.morphology.EnumVerbVoices;
import br.net.heaven.projects.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VerbConjugatedForm {
	
	@Schema(example = "eju", required = true, description = "Verbo na forma conjugada.")
	@JsonProperty("conjugated")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 50)
	private String conjugated;
	
	@Schema(example = "I", required = true, description = "Pessoa na qual o verbo está conjugado.")
	@JsonProperty("person")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 10)
	private EnumVerbPersons person;
	
	@Schema(example = "IMPERFECT", required = true, description = "Tempo verbal no qual o verbo está conjugado.")
	@JsonProperty("tense")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 9)
	private EnumVerbTenses tense;
	
	@Schema(example = "FACTUAL", required = true, description = "Modo verbal no qual o verbo está conjugado.")
	@JsonProperty("mode")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 12)
	private EnumVerbModes mode;
	
	@Schema(example = "ACTIVE", required = true, description = "Voz verbal na qual o verbo está conjugado.")
	@JsonProperty("voice")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 7)
	private EnumVerbVoices voice;
	
	@Schema(example = "INDEFINITE", required = true, description = "Instância de definição do objeto direto na qual o verbo está conjugado.")
	@JsonProperty("definiteness")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 10)
	private EnumVerbDefiniteness definiteness;

}
