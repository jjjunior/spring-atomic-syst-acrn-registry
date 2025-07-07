package br.com.jstack.syst.acrn.registry.application.usecase;

public interface UpdateUseCase<T> {
	T update(T domain);
}