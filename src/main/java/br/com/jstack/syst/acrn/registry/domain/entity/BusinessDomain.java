package br.com.jstack.syst.acrn.registry.domain.entity;

import br.com.jstack.syst.acrn.registry.domain.vo.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "business_domain")
public class BusinessDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "business_domain_id")
	private Long id;
	
	private String  name;
	private String  description;
	private Boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unit_id", nullable = false)
	private BusinessUnit businessUnit;
	
	@Embedded
	private Audit audit = new Audit();
}