package Decks;

import java.util.*;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//The class for a basic Deck
public class Deck<T extends Cards.Card> {

    Vector<T> cards;

    //properties for cards
    public Vector<T> getCards() {
        return cards;
    }
    public void setCards(Vector<T> cards) {
        this.cards = cards;
    }

    //Default constructor
    public Deck(){

    }

    //constructor with a vector of cards
    public Deck(Vector<T> cards){

    }
}
