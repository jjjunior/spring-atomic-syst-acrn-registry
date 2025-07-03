package br.com.jstack.syst.acrn.registry.application.usecase;

public interface CreateUseCase<T> {
	T create(T entity);
}
