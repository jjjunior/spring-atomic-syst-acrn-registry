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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_domain_seq")
	@SequenceGenerator(name = "business_domain_seq", sequenceName = "business_domain_business_domain_id_seq", allocationSize = 1)
	@Column(name = "business_domain_id")
	private Long id;
	
	@NotBlank(message = "Name cannot be blank")
	private String  name;
	
	@NotBlank(message = "Description cannot be blank")
	private String  description;
	
	@NotNull(message = "Active status cannot be null")
	private Boolean active;
	
	@NotNull(message = "Business Unit cannot be null")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unit_id", nullable = false)
	private BusinessUnit businessUnit;
	
	@Embedded
	private Audit audit = new Audit();
}