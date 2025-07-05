package br.com.jstack.syst.acrn.registry.application.port.output;

import java.util.List;

public interface PersistencePort<T, ID> {
	T save(T domain);
	
	T findById(ID id);
	
	List<T> findAll();
	
	void deleteById(ID id);
	
	T update(T domain);
}