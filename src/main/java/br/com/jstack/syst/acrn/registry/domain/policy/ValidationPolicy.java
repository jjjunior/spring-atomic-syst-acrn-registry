package br.com.jstack.syst.acrn.registry.domain.policy;

import br.com.jstack.syst.acrn.registry.domain.vo.OperationType;

public interface ValidationPolicy<T> {
	
	boolean supports(OperationType operation);
	
	void validate(T target);
	
	Class<T> getTargetType();
}