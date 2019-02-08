package CardValues;

import Cards.Card;
import Cards.RankedCard;
import Cards.StandardPlayingCardRank;

import java.util.Vector;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public interface CardValueComparable<K extends Card, V> extends CardValuable<K, V>{
    K getLesserCard(K card1, K card2);
    K getGreaterCard(K card1, K card2);
    K getLowestCard();
    K getHighestCard();
    Vector<RankedCard<StandardPlayingCardRank>> getCardsBelow(K card);
    Vector<RankedCard<StandardPlayingCardRank>> getCardsBelow(V value);
    Vector<RankedCard<StandardPlayingCardRank>> getCardsAbove(K card);
    Vector<RankedCard<StandardPlayingCardRank>> getCardsAbove(V value);
}
