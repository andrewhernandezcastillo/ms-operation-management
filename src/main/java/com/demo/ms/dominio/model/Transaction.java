package com.demo.ms.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Long id;
    private String hashCode;
    private String transactionType;
    private Double amount;
    private Date transactionDate;
}
