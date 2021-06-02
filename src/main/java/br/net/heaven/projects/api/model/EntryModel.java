package br.net.heaven.projects.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "entries")
public class EntryModel extends PanacheEntityBase {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long id;
	
	@Column(name = "entry", length = 30, nullable = false)
	public String entry;
	
	@Column(name = "part_of_speech", length = 2, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public DictionaryPartOfSpeechEnum partOfSpeech;
	
	@Column(name = "meaning", length = 50, nullable = false)
	public String meaning;

}
