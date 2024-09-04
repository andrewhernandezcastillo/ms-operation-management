package com.demo.ms.application.port.output;

import com.demo.ms.dominio.model.Transaction;
import lombok.Generated;

import java.util.List;

@Generated
public interface TransactionCardPersistencePort {
    Transaction addTransaction(Transaction transaction);
    List<Transaction> getTransactions();
}
