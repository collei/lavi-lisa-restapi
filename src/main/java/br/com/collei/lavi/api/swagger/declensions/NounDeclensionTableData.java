package br.com.collei.lavi.api.swagger.declensions;

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
public class NounDeclensionTableData {

	@Schema(example = "eda", required = true, description = "Substantivo a ser declinado. Ele deve estar no nominativo singular.")
	@JsonProperty("noun")
	@NotNull
	@Pattern(regexp = RegexFormatConstants.GENERAL_FORMAT)
	@Size(max = 30)
	private String noun;
	
	@Schema(required = true, description = "Lista de dados das formas declinadas de caso do substantivo mencionado.")
	@JsonProperty("caseDeclensedForms")
	@NotNull
	@Size(min = 1)
	private List<NounDeclensedCaseForm> caseDeclensedForms;
	
	@Schema(required = true, description = "Lista de dados das formas nominativas possessivas do substantivo mencionado.")
	@JsonProperty("possessiveForms")
	@NotNull
	@Size(min = 1)
	private List<NounDeclensedPossessiveForm> possessiveForms;
	
}
