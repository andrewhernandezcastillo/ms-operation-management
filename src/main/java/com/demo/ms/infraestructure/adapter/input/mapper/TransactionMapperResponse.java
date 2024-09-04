package com.demo.ms.infraestructure.adapter.input.mapper;

import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.infraestructure.adapter.input.model.TransactionRequest;
import com.demo.ms.infraestructure.adapter.input.model.TransactionResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapperResponse {
    TransactionResponse transactionToTransactionResponse(Transaction transaction);

    Transaction transactionToTransactionRequest(TransactionRequest transactionRequest);

    List<TransactionResponse> transactionsToTransactionResponses(List<Transaction> transactions);
}
