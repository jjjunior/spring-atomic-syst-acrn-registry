package br.com.jstack.syst.acrn.registry.domain.specification;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SpecificationFactory {
	
	public <T> Specification<T> uniqueName(Function<String, Boolean> existsByNameFn,
	                                       Function<T, String> nameExtractor) {
		return new UniqueNameSpec<>(existsByNameFn, nameExtractor);
	}
}