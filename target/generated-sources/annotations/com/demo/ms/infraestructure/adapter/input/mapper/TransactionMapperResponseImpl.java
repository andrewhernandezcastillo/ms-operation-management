package com.demo.ms.infraestructure.adapter.input.mapper;

import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.infraestructure.adapter.input.model.TransactionRequest;
import com.demo.ms.infraestructure.adapter.input.model.TransactionResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T18:15:02-0500",
    comments = "version: 1.6.0.RC1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class TransactionMapperResponseImpl implements TransactionMapperResponse {

    @Override
    public TransactionResponse transactionToTransactionResponse(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionResponse.TransactionResponseBuilder transactionResponse = TransactionResponse.builder();

        transactionResponse.hashCode( transaction.getHashCode() );
        transactionResponse.transactionType( transaction.getTransactionType() );
        transactionResponse.amount( transaction.getAmount() );
        if ( transaction.getTransactionDate() != null ) {
            transactionResponse.transactionDate( new SimpleDateFormat().format( transaction.getTransactionDate() ) );
        }

        return transactionResponse.build();
    }

    @Override
    public Transaction transactionToTransactionRequest(TransactionRequest transactionRequest) {
        if ( transactionRequest == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.hashCode( transactionRequest.getHashCode() );
        transaction.transactionType( transactionRequest.getTransactionType() );
        transaction.amount( transactionRequest.getAmount() );

        return transaction.build();
    }

    @Override
    public List<TransactionResponse> transactionsToTransactionResponses(List<Transaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<TransactionResponse> list = new ArrayList<TransactionResponse>( transactions.size() );
        for ( Transaction transaction : transactions ) {
            list.add( transactionToTransactionResponse( transaction ) );
        }

        return list;
    }
}
