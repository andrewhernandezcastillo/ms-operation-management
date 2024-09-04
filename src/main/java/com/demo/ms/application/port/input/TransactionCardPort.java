package com.demo.ms.application.port.input;

import com.demo.ms.dominio.model.Transaction;
import java.util.List;

public interface TransactionCardPort {
    Transaction rechargeCard(Transaction transaction);
    Transaction debitoCard(Transaction transaction);
    List<Transaction> getTransactions();
}
