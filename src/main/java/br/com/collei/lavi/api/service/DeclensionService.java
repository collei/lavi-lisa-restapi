package br.com.collei.lavi.api.service;

import br.com.collei.lavi.api.swagger.ResponseNounDeclensionTableData;

public interface DeclensionService {

	ResponseNounDeclensionTableData findDeclensionTable(String noun);

}
