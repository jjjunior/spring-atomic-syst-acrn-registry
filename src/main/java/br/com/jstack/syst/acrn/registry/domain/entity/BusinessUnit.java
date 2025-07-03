package br.com.jstack.syst.acrn.registry.domain.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.jstack.syst.acrn.registry.domain.vo.Audit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	
	@NotBlank(message = "The name must not be blank.")
	@Size(max = 100, message = "The name must be at most 100 characters.")
	private String name;
	
	@NotBlank(message = "The description must not be blank.")
	@Size(max = 255, message = "The description must be at most 255 characters.")
	private String description;
	
	@NotNull(message = "The active status must not be null.")
	private Boolean active;
	
	@Embedded
	private Audit audit = new Audit();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessUnit", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BusinessDomain> businessDomains = new ArrayList<>();
}