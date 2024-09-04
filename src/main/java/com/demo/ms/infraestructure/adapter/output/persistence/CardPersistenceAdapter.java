package com.demo.ms.infraestructure.adapter.output.persistence;

import com.demo.ms.application.port.output.CardPersistencePort;
import com.demo.ms.dominio.model.Card;
import com.demo.ms.infraestructure.adapter.output.mapper.CardMapperAdapter;
import com.demo.ms.infraestructure.adapter.output.repository.CardRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardPersistenceAdapter implements CardPersistencePort {
    private final CardRepositoryAdapter cardRepositoryAdapter;
    private final CardMapperAdapter cardMapperAdapter;

    @Override
    public Card getCardByHashCode(String hashCode) {
        return cardMapperAdapter.toCard(cardRepositoryAdapter.findByHashCode(hashCode));
    }

    @Override
    public Card updateCard(Card card) {
        return cardMapperAdapter.toCard(
                cardRepositoryAdapter.save(
                        cardMapperAdapter.toCardEntity(card)
                )
        );
    }
}
