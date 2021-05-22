package br.com.collei.lavi.api.engine;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.collei.lavi.api.swagger.declensions.NounDeclensedCaseForm;
import br.com.collei.lavi.api.swagger.declensions.NounDeclensedPossessiveForm;
import br.net.heaven.lavi.morphology.core.Noun;
import br.net.heaven.lavi.morphology.enums.EnumNounCases;
import br.net.heaven.lavi.morphology.enums.EnumNounPersons;
import br.net.heaven.lavi.morphology.enums.EnumNounPluralities;
import br.net.heaven.lavi.morphology.inflect.DeclensedItem;
import br.net.heaven.lavi.morphology.inflect.DeclensionTable;

@ApplicationScoped
public class Declinador {

	public List<NounDeclensedCaseForm> declinarCasos(String nounToBeDeclensed) {
		DeclensionTable tabela = new DeclensionTable(new Noun(nounToBeDeclensed));
		List<EnumNounPluralities> pluralidades = EnumNounPluralities.asList();
		List<EnumNounCases> casos = EnumNounCases.asList();
		//
		for (EnumNounPluralities pluralidade : pluralidades) {
			tabela.setPlurality(pluralidade);
			for (EnumNounCases caso : casos) {
				tabela.add(caso);
			}
		}
		//
		List<NounDeclensedCaseForm> lista = new ArrayList<NounDeclensedCaseForm>();
		//
		for (DeclensedItem item : tabela.asItemsList()) {
			lista.add(NounDeclensedCaseForm.builder()
				.declensed(item.getDeclensed().get())
				.nounCase(item.getCase())
				.plurality(item.getPlurality())
				.build()
			);
		}
		//
		return lista;
	}

	public List<NounDeclensedPossessiveForm> declinarPossessivos(String nounToBeDeclensed) {
		DeclensionTable tabela = new DeclensionTable(new Noun(nounToBeDeclensed));
		List<EnumNounPluralities> pluralidades = EnumNounPluralities.asList();
		List<EnumNounPersons> pessoas = EnumNounPersons.asList();
		//
		for (EnumNounPluralities pluralidade : pluralidades) {
			tabela.setPlurality(pluralidade);
			for (EnumNounPersons pessoa : pessoas) {
				tabela.add(pessoa);
			}
		}
		//
		List<NounDeclensedPossessiveForm> lista = new ArrayList<NounDeclensedPossessiveForm>();
		//
		for (DeclensedItem item : tabela.asItemsList()) {
			lista.add(NounDeclensedPossessiveForm.builder()
				.declensed(item.getDeclensed().get())
				.person(item.getPerson())
				.plurality(item.getPlurality())
				.build()
			);
		}
		//
		return lista;
	}

}
