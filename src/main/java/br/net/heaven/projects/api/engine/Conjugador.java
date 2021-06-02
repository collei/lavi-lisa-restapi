package br.net.heaven.projects.api.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.collei.lavi.morphology.EnumVerbDefiniteness;
import br.com.collei.lavi.morphology.EnumVerbModes;
import br.com.collei.lavi.morphology.EnumVerbPersons;
import br.com.collei.lavi.morphology.EnumVerbTenses;
import br.com.collei.lavi.morphology.EnumVerbVoices;
import br.com.collei.lavi.morphology.core.Verb;
import br.com.collei.lavi.morphology.filter.FilterUtils;
import br.com.collei.lavi.morphology.inflect.ConjugatedItem;
import br.com.collei.lavi.morphology.inflect.ConjugationTable;
import br.net.heaven.projects.api.swagger.conjugations.VerbConjugatedForm;

@ApplicationScoped
public class Conjugador {

	public List<VerbConjugatedForm> conjugar(String verbo, List<String> filtros) {
		ConjugationTable tabela = new ConjugationTable(new Verb(verbo));
		List<EnumVerbVoices> voices = EnumVerbVoices.asList();
		List<EnumVerbTenses> tenses = EnumVerbTenses.asList();
		List<EnumVerbPersons> persons = EnumVerbPersons.asList();
		List<EnumVerbDefiniteness> definitenesses = EnumVerbDefiniteness.asList();
		List<EnumVerbModes> modes = Arrays.asList(EnumVerbModes.FACTUAL, EnumVerbModes.DESIDERATIVE);
		List<EnumVerbPersons> personsImperative = Arrays.asList(EnumVerbPersons.YOU, EnumVerbPersons.WE, EnumVerbPersons.YOU_PLURAL);
		//
		for (EnumVerbVoices voice : voices) {
			tabela.setVoice(voice);
			for (EnumVerbModes mode : modes) {
				tabela.setMode(mode);
				for (EnumVerbTenses tense : tenses) {
					tabela.setTense(tense);
					for (EnumVerbDefiniteness definiteness : definitenesses) {
						tabela.setDefiniteness(definiteness);
						for (EnumVerbPersons person : persons) {
							tabela.add(person);
						}
					}
				}
			}
		}
		//
		tabela.setVoice(EnumVerbVoices.ACTIVE);
		tabela.setMode(EnumVerbModes.IMPERATIVE);
		tabela.setTense(EnumVerbTenses.IMPERFECT);
		for (EnumVerbDefiniteness definiteness : definitenesses) {
			tabela.setDefiniteness(definiteness);
			for (EnumVerbPersons person : personsImperative) {
				tabela.add(person);
			}
		}
		//
		List<VerbConjugatedForm> lista = new ArrayList<VerbConjugatedForm>();
		//
		if (filtros != null) {
			for (ConjugatedItem item : tabela.asItemsFiltered(FilterUtils.asFilterList(filtros))) {
				lista.add(VerbConjugatedForm.builder()
							.conjugated(item.getConjugated().get())
							.person(item.getPerson())
							.tense(item.getTense())
							.voice(item.getVoice())
							.mode(item.getMode())
							.definiteness(item.getDefiniteness())
							.build()
				);
			}
		} else {
			for (ConjugatedItem item : tabela.asItemsList()) {
				lista.add(VerbConjugatedForm.builder()
							.conjugated(item.getConjugated().get())
							.person(item.getPerson())
							.tense(item.getTense())
							.voice(item.getVoice())
							.mode(item.getMode())
							.definiteness(item.getDefiniteness())
							.build()
				);
			}
		}
		//
		return lista;
	}
	
	public List<VerbConjugatedForm> conjugar(String verbo) {
		return conjugar(verbo, null);
	}

}
