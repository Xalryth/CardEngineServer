package CardValues;

import Cards.Card;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public interface CardValueComparable<K extends Card, V> extends CardValuable<K, V>{
    K getLesserCard(K card1, K card2);
    K getGreaterCard(K card1, K card2);
    K getLowestCard(K card);
    K getHighestCard(K card);
    K[] getCardsBelow(K card);
    K[] getCardsBelow(V value);
    K[] getCardsAbove(K card);
    K[] getCardsAbove(V value);
}
