package br.com.collei.lavi.api.service;

import br.com.collei.lavi.api.swagger.ResponseDictionaryEntryInfoData;

public interface DictionaryService {

	ResponseDictionaryEntryInfoData findEntryInfo(String entry);

}
