package com.demo.ms.infraestructure.adapter.output.persistence;

import com.demo.ms.application.port.output.TransactionCardPersistencePort;
import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.infraestructure.adapter.output.mapper.TransactionMapperAdapter;
import com.demo.ms.infraestructure.adapter.output.repository.TransactionRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionPersistenceAdapter implements TransactionCardPersistencePort {
    private final TransactionRepositoryAdapter transactionRepositoryAdapter;
    private final TransactionMapperAdapter transactionMapperAdapter;
    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionMapperAdapter.toTransaction(
                transactionRepositoryAdapter.save(transactionMapperAdapter.toTransactionEntity(transaction))) ;
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionMapperAdapter.toTransactions(transactionRepositoryAdapter.findAll());
    }
}
