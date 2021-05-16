package br.com.collei.lavi.api.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import br.com.collei.lavi.api.model.DictionaryPartOfSpeechEnum;
import br.com.collei.lavi.api.model.EntryModel;
import br.com.collei.lavi.api.model.PartsOfSpeechModel;
import br.com.collei.lavi.api.resource.ResourceData;
import br.com.collei.lavi.api.service.DictionaryService;
import br.com.collei.lavi.api.swagger.ResponseDictionaryEntryInfoData;
import br.com.collei.lavi.api.swagger.ResponseDictionaryPartsOfSpeechData;
import br.com.collei.lavi.api.swagger.dictionary.DictionaryEntryDetailedInfo;
import br.com.collei.lavi.api.swagger.dictionary.DictionaryEntryInfo;
import br.com.collei.lavi.api.swagger.dictionary.DictionaryPartOfSpeechInfo;
import br.com.collei.lavi.api.swagger.dictionary.DictionaryPartsOfSpeechListInfo;
import io.quarkus.panache.common.Sort;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@SuppressWarnings("unused")
@Slf4j
public class DictionaryServiceImpl implements DictionaryService {

	@Override
	public ResponseDictionaryEntryInfoData findEntryInfo(String entry) {
		List<EntryModel> entries = EntryModel
				.find(" entry = ?1 ", Sort.by("part_of_speech").and("length(meaning)").and("meaning"), entry)
				.list();
		DictionaryEntryInfo entryInfo = DictionaryEntryInfo.builder()
				.entry(entry)
				.entryDetails(transformEntryInfo(entries))
				.build();
		return ResponseDictionaryEntryInfoData.builder()
				.meta(ResourceData.createMeta())
				.data(entryInfo)
				.build();
	}

	@Override
	public ResponseDictionaryPartsOfSpeechData listPartsofSpeech() {
		List<PartsOfSpeechModel> partsOfSpeech = PartsOfSpeechModel
				.findAll()
				.list();
		DictionaryPartsOfSpeechListInfo data = DictionaryPartsOfSpeechListInfo.builder()
				.count(partsOfSpeech.size())
				.partsOfSpeech(transformPartsOfSpeechInfo(partsOfSpeech))
				.build();
		return ResponseDictionaryPartsOfSpeechData.builder()
				.meta(ResourceData.createMeta())
				.data(data)
				.build();
	}

	/**********
	   ***********
	     ***********
	       ***********
	         ***********
	           ***********
	             ***********/
	
	private List<DictionaryEntryDetailedInfo> transformEntryInfo(List<EntryModel> list) {
		List<DictionaryEntryDetailedInfo> details = new ArrayList<>();
		Set<DictionaryPartOfSpeechEnum> partsOfSpeech = new HashSet<>();
		//
		for (EntryModel em : list) {
			partsOfSpeech.add(em.getPartOfSpeech());
		}
		//
		for (DictionaryPartOfSpeechEnum pos : partsOfSpeech) {
			List<String> meanings = new ArrayList<>();
			//
			for (EntryModel em : list) {
				if (em.getPartOfSpeech() == pos) {
					meanings.add(em.getMeaning());
				}
			}
			//
			DictionaryEntryDetailedInfo detailedInfo = DictionaryEntryDetailedInfo.builder()
				.partOfSpeech(pos)
				.meanings(meanings)
				.build();
			details.add(detailedInfo);
		}
		//
		return details;
	}
	
	
	private List<DictionaryPartOfSpeechInfo> transformPartsOfSpeechInfo(List<PartsOfSpeechModel> list) {
		List<DictionaryPartOfSpeechInfo> details = new ArrayList<>();
		//
		for (PartsOfSpeechModel posm : list) {
			DictionaryPartOfSpeechInfo pos = DictionaryPartOfSpeechInfo.builder()
					.partOfSpeech(posm.getPartOfSpeech())
					.partOfSpeechId(posm.id)
					.abbreviatedForm(posm.abbreviatedForm)
					.partOfSpeechCode(DictionaryPartOfSpeechEnum.from(posm.id))
					.build();
			details.add(pos);
		}
		//
		return details;
	}

}
