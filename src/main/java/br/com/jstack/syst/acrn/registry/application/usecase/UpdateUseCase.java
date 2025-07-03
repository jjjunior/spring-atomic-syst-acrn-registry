package br.com.jstack.syst.acrn.registry.application.usecase;

public interface UpdateUseCase<T, ID> {
	T update(ID id, T entity);
}