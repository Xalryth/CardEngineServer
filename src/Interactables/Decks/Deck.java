package Interactables.Decks;

import Interactables.Cards.Card;

import java.util.Vector;

/*
* @Author Peter C. Straarup 28/01-2019
* Base Deck class for holding a collection of card
* */
public class Deck {
    Vector<Card> cards = new Vector<>();

    public Deck(){ }
    public Deck(Vector<Card> cards){ this.cards = cards; }

    public Vector<Card> getCards(){ return cards; }
    public void setCards(Vector<Card> c){ cards = c;}
}
