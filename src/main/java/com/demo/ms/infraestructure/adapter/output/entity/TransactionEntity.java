package com.demo.ms.infraestructure.adapter.output.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hashCode;
    private String transactionType;
    private Double amount;
    private Date transactionDate;
}
