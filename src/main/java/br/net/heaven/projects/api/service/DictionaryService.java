package br.net.heaven.projects.api.service;

import java.util.Optional;

import br.net.heaven.projects.api.swagger.ResponseDictionaryEntryInfoData;
import br.net.heaven.projects.api.swagger.ResponseDictionaryMeaningInfoData;
import br.net.heaven.projects.api.swagger.ResponseDictionaryPartsOfSpeechData;

public interface DictionaryService {

	Optional<ResponseDictionaryEntryInfoData> findEntryInfo(String entry);

	ResponseDictionaryPartsOfSpeechData listPartsofSpeech();

	Optional<ResponseDictionaryMeaningInfoData> findMeaningInfo(String meaning);

}
