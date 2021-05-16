package br.com.collei.lavi.api.service;

import br.com.collei.lavi.api.swagger.ResponseDictionaryEntryInfoData;
import br.com.collei.lavi.api.swagger.ResponseDictionaryPartsOfSpeechData;

public interface DictionaryService {

	ResponseDictionaryEntryInfoData findEntryInfo(String entry);

	ResponseDictionaryPartsOfSpeechData listPartsofSpeech();

}
