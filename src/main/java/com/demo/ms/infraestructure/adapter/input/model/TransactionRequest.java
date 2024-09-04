package com.demo.ms.infraestructure.adapter.input.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @NotBlank(message = "El campo name no puede estar vacio")
    private String hashCode;
    @NotBlank(message = "El campo name no puede estar vacio")
    private String transactionType;
    private Double amount;

}
