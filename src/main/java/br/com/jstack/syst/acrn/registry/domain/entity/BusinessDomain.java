package br.com.jstack.syst.acrn.registry.domain.entity;

import br.com.jstack.syst.acrn.registry.domain.vo.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "business_domain")
public class BusinessDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_domain_seq")
	@SequenceGenerator(name = "business_domain_seq", sequenceName = "business_domain_business_domain_id_seq", allocationSize = 1)
	@Column(name = "business_domain_id")
	private Long id;
	
	@NotBlank(message = "Name cannot be blank")
	@Column(nullable = false, length = 100)
	private String name;
	
	@NotBlank(message = "Description cannot be blank")
	@Column(nullable = false)
	private String description;
	
	@NotNull(message = "Active status cannot be null")
	@Column(nullable = false)
	private Boolean active;
	
	@Embedded
	private Audit audit = new Audit();
	
	@ManyToMany(mappedBy = "businessDomains", fetch = FetchType.LAZY)
	private List<BusinessUnit> businessUnits = new ArrayList<>();
	
	@OneToMany(mappedBy = "businessDomain", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BusinessUnitDomain> businessUnitDomains = new ArrayList<>();
}