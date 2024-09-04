package com.demo.ms.infraestructure.adapter.output.mapper;

import com.demo.ms.dominio.model.Card;
import com.demo.ms.infraestructure.adapter.output.entity.CardEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-04T18:15:01-0500",
    comments = "version: 1.6.0.RC1, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CardMapperAdapterImpl implements CardMapperAdapter {

    @Override
    public CardEntity toCardEntity(Card card) {
        if ( card == null ) {
            return null;
        }

        CardEntity.CardEntityBuilder cardEntity = CardEntity.builder();

        cardEntity.id( card.getId() );
        cardEntity.hashCode( card.getHashCode() );
        cardEntity.name( card.getName() );
        cardEntity.lastname( card.getLastname() );
        cardEntity.address( card.getAddress() );
        cardEntity.amount( card.getAmount() );

        return cardEntity.build();
    }

    @Override
    public Card toCard(CardEntity cardEntity) {
        if ( cardEntity == null ) {
            return null;
        }

        Card.CardBuilder card = Card.builder();

        card.id( cardEntity.getId() );
        card.hashCode( cardEntity.getHashCode() );
        card.name( cardEntity.getName() );
        card.lastname( cardEntity.getLastname() );
        card.address( cardEntity.getAddress() );
        card.amount( cardEntity.getAmount() );

        return card.build();
    }

    @Override
    public List<Card> toCard(List<CardEntity> cardEntities) {
        if ( cardEntities == null ) {
            return null;
        }

        List<Card> list = new ArrayList<Card>( cardEntities.size() );
        for ( CardEntity cardEntity : cardEntities ) {
            list.add( toCard( cardEntity ) );
        }

        return list;
    }
}
