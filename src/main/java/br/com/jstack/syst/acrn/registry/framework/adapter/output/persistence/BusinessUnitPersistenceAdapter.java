package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository.BusinessUnitRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BusinessUnitPersistenceAdapter implements BusinessUnitOutputPort {
	
	private final EntityManager          entityManager;
	private final BusinessUnitRepository repository;
	
	@Override
	public boolean existsByName(String name) {
		return repository.findByName(name).isPresent();
	}
	
	@Transactional
	@Override
	public BusinessUnit save(BusinessUnit domain) {
		BusinessUnit businessUnit = repository.saveAndFlush(domain);
		entityManager.clear();
		return businessUnit;
	}
	
	@Override
	public Optional<BusinessUnit> findById(Long aLong) {
		return repository.findById(aLong);
	}
	
	@Override
	public List<BusinessUnit> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	@Override
	public void deleteById(Long aLong) {
		repository.deleteById(aLong);
	}
	
	@Transactional
	@Override
	public BusinessUnit update(Long id, BusinessUnit domain) {
		BusinessUnit existing = repository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("Business Unit not found with id: " + id));
		existing.setName(domain.getName());
		existing.setDescription(domain.getDescription());
		existing.setActive(domain.getActive());
		repository.saveAndFlush(existing);
		return existing;
	}
}