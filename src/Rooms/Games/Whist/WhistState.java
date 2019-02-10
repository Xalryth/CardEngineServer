package Rooms.Games.Whist;
/**
 * @author: Philip Hansen
 * @date: 10-02-2019
 * @version 1.0
 */
import CardValues.CardValuable;
import CardValues.CardValueComparable;
import Cards.RankedCard;
import Cards.StandardPlayingCardRank;
import Users.Player;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public abstract class WhistState implements CardValueComparable<RankedCard<StandardPlayingCardRank>,Integer> {
    WhistCalls[] avalableCalls;
    Vector<Player> players = new Vector<>();

    public WhistState(){
        setAvalableCalls();
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public WhistCalls[] getAvalableCalls() {
        return avalableCalls;
    }
    abstract void setAvalableCalls();
    public abstract WhistCalls finalCall();
    public abstract void dealPoints(Vector<Player> players);
    /**the deck of cards used in the game
     */
    Hashtable<RankedCard<StandardPlayingCardRank>,Integer> cards = new Hashtable<>();

    /**Set the cards used for the game
     */
    public void setCards() {Vector<RankedCard<StandardPlayingCardRank>> temp = new Vector<>();
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,1));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,2));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs, 3));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,4));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,5));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,6));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,7));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,8));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,9));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,10));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,11));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,12));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,13));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,1));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,2));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,3));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,4));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,5));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,6));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,7));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,8));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,9));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,10));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,11));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,12));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,13));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,1));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,2));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,3));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,4));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,5));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,6));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,7));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,8));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,9));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,10));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,11));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,12));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,13));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,1));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,2));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,3));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,4));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,5));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,6));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,7));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,8));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,9));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,10));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,11));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,12));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,13));
        for(int i = 0; i < temp.size();i++){
            switch ((int)temp.get(i).getIdentifyer()){
                case 1:cards.put(temp.get(i),14);
                    break;
                case 2:cards.put(temp.get(i),2);
                    break;
                case 3:cards.put(temp.get(i),3);
                    break;
                case 4:cards.put(temp.get(i),4);
                    break;
                case 5:cards.put(temp.get(i),5);
                    break;
                case 6:cards.put(temp.get(i),6);
                    break;
                case 7:cards.put(temp.get(i),7);
                    break;
                case 8:cards.put(temp.get(i),8);
                    break;
                case 9:cards.put(temp.get(i),9);
                    break;
                case 10:cards.put(temp.get(i),10);
                    break;
                case 11:cards.put(temp.get(i),11);
                    break;
                case 12:cards.put(temp.get(i),12);
                    break;
                case 13:cards.put(temp.get(i),13);
                    break;
            }
        }
    }


    /**Compare cards and return the lowest card
     * @param card1 first card to compare
     * @param card2 second card to compare
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getLesserCard(RankedCard<StandardPlayingCardRank> card1,
                                                             RankedCard<StandardPlayingCardRank> card2) {
        if(cards.get(card1) <= cards.get(card2) || card2.getRank() == card1.getRank()) return card1;
        else return card2;
    }

    /**Compare cards and return the highest card
     * @param card1 first card to compare
     * @param card2 second card to compare
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getGreaterCard(RankedCard<StandardPlayingCardRank> card1,
                                                              RankedCard<StandardPlayingCardRank> card2) {
        if(cards.get(card1) >= cards.get(card2) || card1.getRank() != card2.getRank()) return card1;
        else return card2;
    }

    /**Get the lowest card in the deck
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getLowestCard() {
        RankedCard<StandardPlayingCardRank> lowestCard = (new Vector<>(Collections.list(cards.keys()))).get(0);
        for (int i = 1; i < cards.values().size(); i++){
            if ((Integer)cards.values().toArray()[i] < cards.get(lowestCard)){
                lowestCard = (new Vector<>(Collections.list(cards.keys()))).get(i);
            }
        }
        return lowestCard;
    }

    /**Get the highest card in the deck
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getHighestCard() {
        RankedCard<StandardPlayingCardRank> highestCard =
                (new Vector<>(Collections.list(cards.keys()))).get(0);
        for (int i = 1; i < cards.values().size(); i++){
            if ((Integer)cards.values().toArray()[i] > cards.get(highestCard)){
                highestCard = (new Vector<>(Collections.list(cards.keys()))).get(i);
            }
        }
        return highestCard;
    }

    /**Get all cards with a lower value
     * @param card
     * @return
     */
    @Override
    public Vector<RankedCard<StandardPlayingCardRank>> getCardsBelow(RankedCard<StandardPlayingCardRank> card) {
        Vector<RankedCard<StandardPlayingCardRank>> cardsBelow = new Vector<>();
        Vector<RankedCard<StandardPlayingCardRank>> keys = new Vector<>(Collections.list(cards.keys()));
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(keys.get(i)) < cards.get(card)){
                cardsBelow.add(keys.get(i));
            }
        }
        return cardsBelow;
    }

    /**Get cards with a lower value
     * @param value
     * @return
     * */
    @Override
    public Vector<RankedCard<StandardPlayingCardRank>> getCardsBelow(Integer value) {
        Vector<RankedCard<StandardPlayingCardRank>> cardsBelow = new Vector<>();
        Vector<RankedCard<StandardPlayingCardRank>> keys = new Vector<>(Collections.list(cards.keys()));
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(keys.get(i)) < value){
                cardsBelow.add(keys.get(i));
            }
        }
        return cardsBelow;
    }

    /**Get all cards with a higher value
     * @param card
     * @return
     */
    @Override
    public Vector<RankedCard<StandardPlayingCardRank>> getCardsAbove(RankedCard<StandardPlayingCardRank> card) {
        Vector<RankedCard<StandardPlayingCardRank>> cardsAbove = new Vector<>();
        Vector<RankedCard<StandardPlayingCardRank>> keys = new Vector<>(Collections.list(cards.keys()));
        for(int i = cards.size(); i > 0; i--){
            if (cards.get(keys.get(i)) < cards.get(card)){
                cardsAbove.add(keys.get(i));
            }
        }
        return cardsAbove;
    }

    /**Get all cards with a higher value
     * @param value
     * @return
     */
    @Override
    public Vector<RankedCard<StandardPlayingCardRank>> getCardsAbove(Integer value) {
        Vector<RankedCard<StandardPlayingCardRank>> cardsAbove = new Vector<>();
        Vector<RankedCard<StandardPlayingCardRank>> keys = new Vector<>(Collections.list(cards.keys()));
        for(int i = cards.size(); i > 0; i--){
            if (cards.get(keys.get(i)) < value){
                cardsAbove.add(keys.get(i));
            }
        }
        return cardsAbove;
    }

    @Override
    public Hashtable<RankedCard<StandardPlayingCardRank>, Integer> getCardValues() {
        return cards;
    }

    @Override
    public void setCardValues(Hashtable<RankedCard<StandardPlayingCardRank>, Integer> cardValues) {
        cards = cardValues;
    }

    @Override
    public void addCardValuePair(RankedCard<StandardPlayingCardRank> card, Integer value) {
        cards.put(card,value);
    }

    @Override
    public void alterCardValue(RankedCard<StandardPlayingCardRank> card, Integer value) {
        cards.put(card,value);
    }

    @Override
    public void removeCardValuePair(RankedCard<StandardPlayingCardRank> card) {
        cards.remove(card);
    }

}
