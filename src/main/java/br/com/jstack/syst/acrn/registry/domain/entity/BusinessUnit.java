package br.com.jstack.syst.acrn.registry.domain.entity;

import br.com.jstack.syst.acrn.registry.domain.vo.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "business_unit")
public class BusinessUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "business_unit_id")
	private Long id;
	
	private String name;
	
	private String description;
	
	private Boolean active;
	
	@Embedded
	private Audit audit = new Audit();
}