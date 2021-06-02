package br.net.heaven.projects.api.service;

import br.net.heaven.projects.api.swagger.ResponseNounDeclensionTableData;

public interface DeclensionService {

	ResponseNounDeclensionTableData findDeclensionTable(String noun);

}
