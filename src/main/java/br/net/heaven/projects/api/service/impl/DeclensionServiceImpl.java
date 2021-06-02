package br.net.heaven.projects.api.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.net.heaven.projects.api.engine.Declinador;
import br.net.heaven.projects.api.resource.ResourceData;
import br.net.heaven.projects.api.service.DeclensionService;
import br.net.heaven.projects.api.swagger.ResponseNounDeclensionTableData;
import br.net.heaven.projects.api.swagger.declensions.NounDeclensedCaseForm;
import br.net.heaven.projects.api.swagger.declensions.NounDeclensedPossessiveForm;
import br.net.heaven.projects.api.swagger.declensions.NounDeclensionTableData;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@SuppressWarnings("unused")
@Slf4j
public class DeclensionServiceImpl implements DeclensionService {

	@Inject
	Declinador declinador;
	
	@Override
	public ResponseNounDeclensionTableData findDeclensionTable(String nounToBeDeclensed) {
		List<NounDeclensedCaseForm> declinados = declinador.declinarCasos(nounToBeDeclensed);
		List<NounDeclensedPossessiveForm> possessivos = declinador.declinarPossessivos(nounToBeDeclensed);
		//
		NounDeclensionTableData data = NounDeclensionTableData.builder()
				.noun(nounToBeDeclensed)
				.caseDeclensedForms(declinados)
				.possessiveForms(possessivos)
				.build();
		return ResponseNounDeclensionTableData.builder()
				.meta(ResourceData.createMeta())
				.data(data)
				.build();
	}

}
