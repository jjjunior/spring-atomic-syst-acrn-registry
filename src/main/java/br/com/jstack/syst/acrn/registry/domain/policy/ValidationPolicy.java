package br.com.jstack.syst.acrn.registry.domain.policy;

public interface ValidationPolicy<T> {
	
	boolean supports(OperationType operation);
	
	void validate(T target);
}