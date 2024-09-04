package com.demo.ms.infraestructure.adapter.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;


@Getter
@Setter
@Builder
@Entity
@Table(name = "card")
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hashCode;
    private String name;
    private String lastname;
    private String address;
    private Double amount;
}
