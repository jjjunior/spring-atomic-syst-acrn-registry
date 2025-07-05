package br.com.jstack.syst.acrn.registry.domain.policy;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PolicyResolver<T> {
	
	private final List<ValidationPolicy<T>> policies;
	
	public PolicyResolver(List<ValidationPolicy<T>> policies) {
		this.policies = policies;
	}
	
	public ValidationPolicy<T> resolve(OperationType operation) {
		return policies.stream()
			.filter(policy -> policy.supports(operation))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("No policy found for operation: " + operation));
	}
}