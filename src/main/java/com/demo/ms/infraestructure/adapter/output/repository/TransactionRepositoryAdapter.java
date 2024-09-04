package com.demo.ms.infraestructure.adapter.output.repository;

import com.demo.ms.infraestructure.adapter.output.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositoryAdapter extends JpaRepository<TransactionEntity, Long> {
}
