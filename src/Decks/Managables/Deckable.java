package Decks.Managables;

import Decks.Deck;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Interface to define the Deck
public interface Deckable<T> extends MultiDeckable, SingelDeckable {

    //Methods a deck needs
    void shuffleDeck();
    boolean searchDeck(T searchDeck);

    Deck createDeck();
    void discardCards(T discardCards);

}
