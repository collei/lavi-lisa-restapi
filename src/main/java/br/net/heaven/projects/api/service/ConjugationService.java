package br.net.heaven.projects.api.service;

import java.util.List;

import br.net.heaven.projects.api.swagger.ResponseVerbConjugationTableData;

public interface ConjugationService {
	
	ResponseVerbConjugationTableData findConjugationTable(String verbToBeConjugated);

	ResponseVerbConjugationTableData findConjugationTableFiltered(String verbToBeConjugated, List<String> filters);

}
