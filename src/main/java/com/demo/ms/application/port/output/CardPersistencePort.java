package com.demo.ms.application.port.output;

import com.demo.ms.dominio.model.Card;

public interface CardPersistencePort {
    Card getCardByHashCode(String hashCode);
    Card updateCard(Card card);
}
