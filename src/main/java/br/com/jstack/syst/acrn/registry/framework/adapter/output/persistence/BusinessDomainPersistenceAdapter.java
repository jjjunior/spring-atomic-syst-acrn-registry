package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessDomainOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessDomain;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository.BusinessDomainRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
	
	@Transactional
	@Override
	public BusinessDomain save(BusinessDomain domain) {
		BusinessDomain businessUnit = repository.saveAndFlush(domain);
		entityManager.clear();
		return businessUnit;
	}
	
	@Override
	public Optional<BusinessDomain> findById(Long aLong) {
		return repository.findById(aLong);
	}
	
	@Override
	public List<BusinessDomain> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	@Override
	public void deleteById(Long aLong) {
		repository.deleteById(aLong);
	}
	
	@Transactional
	@Override
	public BusinessDomain update(Long id, BusinessDomain domain) {
		BusinessDomain existing = repository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("Business Domain not found with id: " + id));
		existing.setName(domain.getName());
		existing.setDescription(domain.getDescription());
		existing.setActive(domain.getActive());
		repository.saveAndFlush(existing);
		return existing;
	}
}