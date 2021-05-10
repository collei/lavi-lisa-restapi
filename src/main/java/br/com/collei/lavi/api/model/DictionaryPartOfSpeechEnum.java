package br.com.collei.lavi.api.model;

import java.util.Arrays;
import java.util.List;

import br.net.heaven.lavi.morphology.enums.EnumPartsOfSpeech;

public enum DictionaryPartOfSpeechEnum {

	UNDEFINED(0),
	NOUN(1),
	ADJECTIVE(2),
	ADVERB(3),
	VERB(4),
	PREPOSITION(5),
	POSTPOSITION(6),
	CIRCUMPOSITION(7),
	PRONOUN(8),
	NUMBER(9),
	DISCOURSE_MARKER(10),
	PARTICLE(11),
	CONJUNCTION(12),
	INTERJECTION(13),
	ASPECT_MARKER(14),
	EVIDENCE_MARKER(15),
	EMPHASIZER(16),
	SEPARATOR(17),
	MODE_MARKER(18),
	TENSE_MARKER(19),
	COVERB(20),
	COPULA(21),
	PREFIX(22),
	SUFFIX(23),
	PHRASE(24);
	
	private int value;
	
	DictionaryPartOfSpeechEnum(int value) {
		this.value = value;
	}
	
	public static DictionaryPartOfSpeechEnum from(EnumPartsOfSpeech partOfSpeech) {
		List<EnumPartsOfSpeech> listFrom = EnumPartsOfSpeech.asList();
		List<DictionaryPartOfSpeechEnum> listTo = DictionaryPartOfSpeechEnum.asList();
		//
		for (EnumPartsOfSpeech partFrom : listFrom) {
			for (DictionaryPartOfSpeechEnum partTo : listTo) {
				if (partFrom.name().equals(partTo.name())) {
					return partTo;
				}
			}
		}
		//
		return UNDEFINED;
	}
	
	public static List<DictionaryPartOfSpeechEnum> asList() {
		return Arrays.asList(NOUN,ADJECTIVE,ADVERB,VERB,PREPOSITION,POSTPOSITION,
				CIRCUMPOSITION,PRONOUN,NUMBER,DISCOURSE_MARKER,PARTICLE,
				CONJUNCTION,INTERJECTION,ASPECT_MARKER,EVIDENCE_MARKER,
				EMPHASIZER,SEPARATOR,MODE_MARKER,TENSE_MARKER,COVERB,COPULA,PREFIX,SUFFIX,PHRASE);
	}
	
	public int getValue() {
		return this.value;
	}
	
}
