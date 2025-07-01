package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.jstack.syst.acrn.registry.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.syst.acrn.registry.domain.entity.BusinessUnit;
import br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.repository.BusinessUnitRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BusinessUnitPersistenceAdapter implements BusinessUnitOutputPort {
	
	private final EntityManager          entityManager;
	private final BusinessUnitRepository businessUnitRepository;
	
	@Transactional
	@Override
	public void persistBusinessUnit(BusinessUnit businessUnit) {
		businessUnitRepository.saveAndFlush(businessUnit);
		entityManager.clear();
	}
	
	@Transactional
	@Override
	public void removeBusinessUnit(Long id) {
		if (!businessUnitRepository.existsById(id)) {
			throw new NoSuchElementException("Cannot delete: Business Unit not found with id: " + id);
		}
		businessUnitRepository.deleteById(id);
	}
	
	@Override
	public BusinessUnit retrieveBusinessUnit(Long id) {
		return businessUnitRepository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("Business Unit not found with id: " + id));
	}
	
	@Override
	public List<BusinessUnit> listBusinessUnits() {
		return businessUnitRepository.findAll();
	}
	
	@Transactional
	@Override
	public void changeBusinessUnit(Long id, BusinessUnit updatedBusinessUnit) {
		BusinessUnit existing = businessUnitRepository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("Business Unit not found with id: " + id));
		
		existing.setName(updatedBusinessUnit.getName());
		existing.setDescription(updatedBusinessUnit.getDescription());
		existing.setActive(updatedBusinessUnit.getActive());
		businessUnitRepository.saveAndFlush(existing);
		entityManager.clear();
	}
}