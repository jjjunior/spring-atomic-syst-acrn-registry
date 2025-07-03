package br.com.jstack.syst.acrn.registry.application.usecase;

public interface RetrieveByIdUseCase<T, ID> {
	T retrieveById(ID id);
}