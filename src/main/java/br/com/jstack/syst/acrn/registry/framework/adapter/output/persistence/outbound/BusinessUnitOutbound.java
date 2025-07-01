package br.com.jstack.syst.acrn.registry.framework.adapter.output.persistence.outbound;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BusinessUnitOutbound(
	
	@NotNull
	Long id,
	
	@NotBlank(message = "The name must not be blank.")
	@Size(max = 100, message = "The name must be at most 100 characters.")
	String name,
	
	@Size(max = 255, message = "The description must be at most 255 characters.")
	String description,
	
	@NotNull
	Boolean active,
	
	@NotBlank
	String createdBy,
	
	@NotNull
	LocalDateTime createdAt,
	
	String updatedBy,
	
	LocalDateTime updatedAt
) {
}
