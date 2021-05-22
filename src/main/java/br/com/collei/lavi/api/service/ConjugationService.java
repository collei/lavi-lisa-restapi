package br.com.collei.lavi.api.service;

import java.util.List;

import br.com.collei.lavi.api.swagger.ResponseVerbConjugationTableData;

public interface ConjugationService {
	
	ResponseVerbConjugationTableData findConjugationTable(String verbToBeConjugated);

	ResponseVerbConjugationTableData findConjugationTableFiltered(String verbToBeConjugated, List<String> filters);

}
