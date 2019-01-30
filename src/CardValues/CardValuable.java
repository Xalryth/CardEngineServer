package CardValues;

import Cards.Card;
import java.util.Hashtable;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public interface CardValuable<K extends Card, V>{
    Hashtable<K, V> getCardValues();
    void setCardValues(Hashtable<K, V> cardValues);
    void addCardValuePair(K card, V value);
    void alterCardValue(K card, V value);
    void removeCardValuePair(K card);
}
