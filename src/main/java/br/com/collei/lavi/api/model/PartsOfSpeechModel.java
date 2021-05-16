package br.com.collei.lavi.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "parts_of_speech")
public class PartsOfSpeechModel extends PanacheEntityBase {
	
	@Id
	@Column(name = "id")
	public Long id;
	
	@Column(name = "part_of_speech", length = 16, nullable = false)
	public String partOfSpeech;
	
	@Column(name = "abbreviated_form", length = 8, nullable = false)
	public String abbreviatedForm;

}
