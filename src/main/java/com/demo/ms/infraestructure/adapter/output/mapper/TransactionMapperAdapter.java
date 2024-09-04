package com.demo.ms.infraestructure.adapter.output.mapper;

import com.demo.ms.dominio.model.Card;
import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.infraestructure.adapter.input.model.TransactionResponse;
import com.demo.ms.infraestructure.adapter.output.entity.CardEntity;
import com.demo.ms.infraestructure.adapter.output.entity.TransactionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapperAdapter {
   TransactionEntity toTransactionEntity(Transaction transaction);
   Transaction toTransaction(TransactionEntity transactionEntity);
   List<Transaction> toTransactions(List<TransactionEntity> transactionEntities);
}
