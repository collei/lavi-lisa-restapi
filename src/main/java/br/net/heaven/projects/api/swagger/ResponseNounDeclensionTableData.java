package br.net.heaven.projects.api.swagger;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.net.heaven.projects.api.swagger.declensions.NounDeclensionTableData;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseNounDeclensionTableData {
	
	@Schema(required = true, description = "Tabela de declinação do substantivo solicitado.")
	@JsonProperty("data")
	@NotNull
	private NounDeclensionTableData data;
	
	@Schema(required = true, description = "Metainformações da resposta solicitada.")
	@JsonProperty("meta")
	@NotNull
	private Meta meta;

}
