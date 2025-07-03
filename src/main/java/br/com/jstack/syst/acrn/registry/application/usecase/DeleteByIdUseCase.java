package br.com.jstack.syst.acrn.registry.application.usecase;

public interface DeleteByIdUseCase<T, ID> {
	void deleteteById(ID id);
}