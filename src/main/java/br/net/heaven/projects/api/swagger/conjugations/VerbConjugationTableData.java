package br.net.heaven.projects.api.swagger.conjugations;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.net.heaven.projects.api.util.RegexFormatConstants;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VerbConjugationTableData {
	
	@Schema(example = "eda", required = true, description = "Verbo a ser conjugado. Ele deve estar no infinitivo.")
	@JsonProperty("verb")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 30)
	private String verb;
	
	@Schema(required = true, description = "Lista de dados das formas conjugadas do verbo mencionado.")
	@JsonProperty("conjugatedForms")
	@NotNull
	@Size(min = 1)
	private List<VerbConjugatedForm> conjugatedForms;

}
