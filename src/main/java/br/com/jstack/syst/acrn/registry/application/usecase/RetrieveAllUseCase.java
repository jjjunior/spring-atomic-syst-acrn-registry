package br.com.jstack.syst.acrn.registry.application.usecase;

import java.util.List;

public interface RetrieveAllUseCase<T> {
	List<T> retrieveAll();
}