package br.com.jstack.syst.acrn.registry.framework.adapter.input.rest.inbound;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BusinessUnitInbound(
	
	Long id,
	
	@NotBlank(message = "The name must not be blank.")
	@Size(max = 100, message = "The name must be at most 100 characters.")
	String name,
	
	@Size(max = 255, message = "The description must be at most 255 characters.")
	String description,
	
	Boolean active
) {
}