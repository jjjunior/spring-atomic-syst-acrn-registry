package br.com.jstack.syst.acrn.registry.domain.policy;

import org.springframework.stereotype.Component;

@Component
public interface ValidationPolicy<T> {
	void validate(T entity);
}