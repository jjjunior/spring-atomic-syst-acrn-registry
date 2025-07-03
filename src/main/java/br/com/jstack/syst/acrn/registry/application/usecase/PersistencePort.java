package br.com.jstack.syst.acrn.registry.application.usecase;

import java.util.List;
import java.util.Optional;

public interface PersistencePort<T, ID> {
	T save(T domain);
	
	Optional<T> findById(ID id);
	
	List<T> findAll();
	
	void deleteById(ID id);
	
	T update(ID id, T domain);
}