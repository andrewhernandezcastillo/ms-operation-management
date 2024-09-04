package com.demo.ms.application.port.service;

import com.demo.ms.application.port.input.TransactionCardPort;
import com.demo.ms.application.port.output.CardPersistencePort;
import com.demo.ms.application.port.output.TransactionCardPersistencePort;
import com.demo.ms.dominio.exception.InsufficientFundsException;
import com.demo.ms.dominio.exception.DoesNotExistCardException;
import com.demo.ms.dominio.model.Transaction;
import com.demo.ms.dominio.model.Card;
import com.demo.ms.utils.commons.Constants;
import com.demo.ms.utils.commons.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionCardServices implements TransactionCardPort {
    private final TransactionCardPersistencePort transactionCardPersistencePort;
    private final CardPersistencePort cardPersistencePort;
    private Double amount;


    @Override
    public Transaction rechargeCard(Transaction transaction) {
        Card card = cardPersistencePort.getCardByHashCode(transaction.getHashCode());

        if (card == null) {
            throw new DoesNotExistCardException(
                    Constants.COD_EX_NOTEXISTCARD,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    Constants.MSG_EX_NOTEXISTTYPEOPERATION + transaction.getHashCode());
        }
        amount = card.getAmount() + transaction.getAmount();
        card.setAmount(amount);
        cardPersistencePort.updateCard(card);
        transaction.setTransactionDate(Util.getToday());
        return transactionCardPersistencePort.addTransaction(transaction);

    }

    @Override
    public Transaction debitoCard(Transaction transaction) {
        Card card = cardPersistencePort.getCardByHashCode(transaction.getHashCode());
        if (card == null) {
            throw new DoesNotExistCardException(
                    Constants.COD_EX_NOTEXISTCARD,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    Constants.MSG_EX_NOTEXISTTYPEOPERATION + transaction.getHashCode());
        }
        if (card.getAmount() < transaction.getAmount()) {
            throw new InsufficientFundsException(
                    Constants.COD_EX_INSUFFICIENTFOUNDS,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    Constants.MSG_EX_INSUFFICIENTFOUNDS);
        }

        amount = card.getAmount() - transaction.getAmount();
        card.setAmount(amount);
        cardPersistencePort.updateCard(card);
        transaction.setTransactionDate(Util.getToday());
        return transactionCardPersistencePort.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionCardPersistencePort.getTransactions();
    }
}
