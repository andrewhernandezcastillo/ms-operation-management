package com.demo.ms.application.port.service;

import com.demo.ms.application.port.output.TransactionCardPersistencePort;
import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.utils.commons.Util;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TransactionCardServicesTest {
    TransactionCardPersistencePort service = Mockito.mock(TransactionCardPersistencePort.class);

    public Transaction createTransaction(){
    return Transaction.builder()
            .id(Long.valueOf(1))
            .hashCode("aaae7757-4e99-4243-ba6c-7c97c35a465d")
            .transactionType("recarga")
            .amount(200.0)
            .transactionDate(Util.getToday())
            .build();
}

    @Test
    void getTransactions() {
        when(service.getTransactions()).thenReturn(Collections.singletonList(createTransaction()));
        final List<Transaction> transactions=service.getTransactions();
        assertNotNull(transactions);
        assertEquals(1,transactions.size());
        Mockito.verify(service).getTransactions();
    }
}