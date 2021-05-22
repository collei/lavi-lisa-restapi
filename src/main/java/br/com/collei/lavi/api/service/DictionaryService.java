package br.com.collei.lavi.api.service;

import java.util.Optional;

import br.com.collei.lavi.api.swagger.ResponseDictionaryEntryInfoData;
import br.com.collei.lavi.api.swagger.ResponseDictionaryMeaningInfoData;
import br.com.collei.lavi.api.swagger.ResponseDictionaryPartsOfSpeechData;

public interface DictionaryService {

	Optional<ResponseDictionaryEntryInfoData> findEntryInfo(String entry);

	ResponseDictionaryPartsOfSpeechData listPartsofSpeech();

	Optional<ResponseDictionaryMeaningInfoData> findMeaningInfo(String meaning);

}
