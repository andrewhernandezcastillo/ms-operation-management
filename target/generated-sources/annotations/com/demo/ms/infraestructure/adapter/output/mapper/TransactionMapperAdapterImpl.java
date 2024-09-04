package com.demo.ms.infraestructure.adapter.output.mapper;

import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.infraestructure.adapter.output.entity.TransactionEntity;
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
public class TransactionMapperAdapterImpl implements TransactionMapperAdapter {

    @Override
    public TransactionEntity toTransactionEntity(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionEntity.TransactionEntityBuilder transactionEntity = TransactionEntity.builder();

        transactionEntity.id( transaction.getId() );
        transactionEntity.hashCode( transaction.getHashCode() );
        transactionEntity.transactionType( transaction.getTransactionType() );
        transactionEntity.amount( transaction.getAmount() );
        transactionEntity.transactionDate( transaction.getTransactionDate() );

        return transactionEntity.build();
    }

    @Override
    public Transaction toTransaction(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }

        Transaction.TransactionBuilder transaction = Transaction.builder();

        transaction.id( transactionEntity.getId() );
        transaction.hashCode( transactionEntity.getHashCode() );
        transaction.transactionType( transactionEntity.getTransactionType() );
        transaction.amount( transactionEntity.getAmount() );
        transaction.transactionDate( transactionEntity.getTransactionDate() );

        return transaction.build();
    }

    @Override
    public List<Transaction> toTransactions(List<TransactionEntity> transactionEntities) {
        if ( transactionEntities == null ) {
            return null;
        }

        List<Transaction> list = new ArrayList<Transaction>( transactionEntities.size() );
        for ( TransactionEntity transactionEntity : transactionEntities ) {
            list.add( toTransaction( transactionEntity ) );
        }

        return list;
    }
}
