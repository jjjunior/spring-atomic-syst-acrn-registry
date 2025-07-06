package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository.BusinessDomainRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BusinessDomainPersistenceAdapter implements BusinessDomainOutputPort {
	
	private final EntityManager            entityManager;
	private final BusinessDomainRepository repository;
	
	@Override
	public boolean existsByName(String name) {
		return repository.findByName(name).isPresent();
	}
	
	@Override
	public boolean existsByNameAndIdNot(String name, Long id) {
		return repository.findByNameAndIdNot(name, id).isPresent();
	}
	
	@Transactional
	@Override
	public BusinessDomain save(BusinessDomain domain) {
		BusinessDomain businessUnit = repository.saveAndFlush(domain);
		entityManager.clear();
		return businessUnit;
	}
	
	@Override
	public BusinessDomain findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Business Domain with id " + id + " not found"));
	}
	
	@Override
	public List<BusinessDomain> findAll() {
		return repository.findAll(Sort.by("id").ascending());
	}
	
	@Transactional
	@Override
	public void deleteById(Long aLong) {
		repository.deleteById(aLong);
	}
	
	@Transactional
	@Override
	public BusinessDomain update(BusinessDomain domain) {
		BusinessDomain existing = findById(domain.getId());
		existing.setName(domain.getName());
		existing.setDescription(domain.getDescription());
		existing.setActive(domain.getActive());
		existing.setBusinessUnit(domain.getBusinessUnit());
		repository.saveAndFlush(existing);
		return existing;
	}
}