package br.net.heaven.projects.api.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.net.heaven.projects.api.engine.Conjugador;
import br.net.heaven.projects.api.resource.ResourceData;
import br.net.heaven.projects.api.service.ConjugationService;
import br.net.heaven.projects.api.swagger.ResponseVerbConjugationTableData;
import br.net.heaven.projects.api.swagger.conjugations.VerbConjugatedForm;
import br.net.heaven.projects.api.swagger.conjugations.VerbConjugationTableData;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@SuppressWarnings("unused")
@Slf4j
public class ConjugationServiceImpl implements ConjugationService {

	@Inject
	Conjugador conjugador;
	
	@Override
	public ResponseVerbConjugationTableData findConjugationTable(String verbToBeConjugated) {
		List<VerbConjugatedForm> lista = conjugador.conjugar(verbToBeConjugated);
		VerbConjugationTableData data = VerbConjugationTableData.builder()
				.verb(verbToBeConjugated)
				.conjugatedForms(lista)
				.build();
		return ResponseVerbConjugationTableData.builder()
				.meta(ResourceData.createMeta())
				.data(data)
				.build();
	}

	@Override
	public ResponseVerbConjugationTableData findConjugationTableFiltered(String verbToBeConjugated, List<String> filters) {
		List<VerbConjugatedForm> lista = conjugador.conjugar(verbToBeConjugated, filters);
		VerbConjugationTableData data = VerbConjugationTableData.builder()
				.verb(verbToBeConjugated)
				.conjugatedForms(lista)
				.build();
		return ResponseVerbConjugationTableData.builder()
				.meta(ResourceData.createMeta())
				.data(data)
				.build();
	}

}
