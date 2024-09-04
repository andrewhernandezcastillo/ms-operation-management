package com.demo.ms.infraestructure.adapter.output.repository;

import com.demo.ms.infraestructure.adapter.output.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepositoryAdapter extends JpaRepository<CardEntity, String> {
    CardEntity findByHashCode (String hashCode);
}
