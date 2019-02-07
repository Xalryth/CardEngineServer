/**
 * @author: Philip Hansen, Rasmus Rosenkjær
 * @date: 04-02-2019
 * @version 1.0
 */
package Rooms.Games.Whist;

import CardValues.CardValueComparable;
import Cards.Card;
import Cards.RankedCard;
import Cards.StandardPlayingCardRank;
import Decks.Deck;
import Decks.Hand;
import EndPoints.CardWebsocketServer;
import Managers.TurnManager;
import Rooms.Games.Game;
import Users.Player;
import Users.User;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

import static javax.swing.UIManager.getString;
import static javax.swing.UIManager.put;

public class WhistGamemode extends Game implements TurnManager, CardValueComparable<RankedCard<StandardPlayingCardRank>,Integer> {

    int turnCount = 0;
    int roundCount = 0;
    Vector<Player> turnQueue = new Vector<>();
    boolean isClockwise = true;

    /**the deck of cards used in the game
     */
    Hashtable<RankedCard<StandardPlayingCardRank>,Integer> cards;
    /**The deck to deal cards from
     */
    Deck<RankedCard<StandardPlayingCardRank>> deck;
    /**The game pile
     */
    Deck<RankedCard<StandardPlayingCardRank>> pile;

    WhistCalls[] whistCalls= new WhistCalls[4];
    CardWebsocketServer cardWebsocketServer;
    protected StandardPlayingCardRank trumf;

    public WhistGamemode(String name) {
        super(name);
    }

    public void setCards() {
        Vector<RankedCard<StandardPlayingCardRank>> temp = new Vector<>();
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Ace Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Two Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs, "Three Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Four Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Five Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Six Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Seven Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Eight Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Nine Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Ten Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Jack Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"Queen Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Clubs,"King Of Clubs"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Ace Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Two Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Three Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Four Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Five Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Six Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Seven Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Eight Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Nine Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Ten Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Jack Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"Queen Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Diamonds,"King Of Diamonds"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Ace Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Two Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Three Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Four Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Five Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Six Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Seven Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Eight Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Nine Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Ten Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Jack Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"Queen Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Hearts,"King Of Hearts"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Ace Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Two Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Three Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Four Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Five Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Six Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Seven Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Eight Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Nine Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Ten Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Jack Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"Queen Of Spades"));
        temp.add(new RankedCard<>(StandardPlayingCardRank.Spades,"King Of Spades"));
        for(int i = 0; i < temp.size();i++){
            if(temp.get(i).getIdentifyer().toString().contains("Ace")) cards.put(temp.get(i),14);
            else if(temp.get(i).getIdentifyer().toString().contains("Two")) cards.put(temp.get(i),2);
            else if(temp.get(i).getIdentifyer().toString().contains("Three")) cards.put(temp.get(i),3);
            else if(temp.get(i).getIdentifyer().toString().contains("Four")) cards.put(temp.get(i),4);
            else if(temp.get(i).getIdentifyer().toString().contains("Five")) cards.put(temp.get(i),5);
            else if(temp.get(i).getIdentifyer().toString().contains("Six")) cards.put(temp.get(i),6);
            else if(temp.get(i).getIdentifyer().toString().contains("Seven")) cards.put(temp.get(i),7);
            else if(temp.get(i).getIdentifyer().toString().contains("Eight")) cards.put(temp.get(i),8);
            else if(temp.get(i).getIdentifyer().toString().contains("Nine")) cards.put(temp.get(i),9);
            else if(temp.get(i).getIdentifyer().toString().contains("Ten")) cards.put(temp.get(i),10);
            else if(temp.get(i).getIdentifyer().toString().contains("Jack")) cards.put(temp.get(i),11);
            else if(temp.get(i).getIdentifyer().toString().contains("Queen")) cards.put(temp.get(i),12);
            else if(temp.get(i).getIdentifyer().toString().contains("King")) cards.put(temp.get(i),13);
        }
    }

    @Override
    public void startGame(User[] users) {
        //Make sure all spots are filled
        if (!(users.length == 4)) throw new ArrayStoreException("Too Many Players");
        Vector<Player> players = new Vector<>();
        for (int i = 0; i< users.length; i++){
            Player tempPlayer = new Player(users[i]);
            players.add(tempPlayer);
            turnQueue.add(tempPlayer);
        }

        turnCount++;
        setPlayers(players);
        setGameStarted(true);
        setPlayerTurnOrder();
        dealHands();
    }

    //A method to call the type of game for this round
    public void call(WhistCalls call){

        //send call to other players
    }

    //A method to play a cretan card
    public void playCard(RankedCard<StandardPlayingCardRank> card){
        if(getCurrentPlayer().getHand().getCards().contains(card)){
            Vector<RankedCard<StandardPlayingCardRank>> temp = pile.getCards();
            temp.add(card);
            pile.setCards(temp);
        }
    }

    //A method to send a new hand to all players
    public void dealHands(){
        for (int i = 0; i < getPlayers().size();i++){
            getPlayers().get(i).setHand(new Hand(13));
        }
        Collections.shuffle(deck.getCards());
        int player = 0;
        while (deck.getCards().size()!= 0){
            getPlayers().get(player).getHand().getCards().add(deck.getCards().remove(0));
            player = player++;
            if (player == 4) player = 0;
        }

    }

    @Override
    public void endGame() {

    }

    @Override
    public int getTurnCount() {
        return turnCount;
    }

    @Override
    public Vector<Player> getTurnQueue() {
        return turnQueue;
    }

    @Override
    public Player getCurrentPlayer() {
        int currentRound = (int) Math.ceil(turnCount / 4.0);
        return getPlayers().get(turnCount - ((currentRound - 1) * 4) -1);

    }

    @Override
    public Player endTurn() {
        //Figure out what card wins
        RankedCard<StandardPlayingCardRank> winningCard = pile.getCards().get(0);
        Player winningPlayer = turnQueue.get(0);
        for (int i = 1; i < pile.getCards().size();i++){
            if(winningCard != getGreaterCard(winningCard, pile.getCards().get(i))){
                winningPlayer = turnQueue.get(i);
                winningCard = getGreaterCard(winningCard, pile.getCards().get(i));
            }
        }

        int currentRound = (int) Math.ceil(turnCount / 4.0);
        if(currentRound == 4) {
            roundCount = roundCount++;
            turnCount = 0;
        }
        int index = turnCount - ((currentRound - 1) * 4);
        if (index == 5) index = 1;
        turnCount = turnCount++;
        return getPlayers().get(index - 1);
    }

    @Override
    public void switchTurnOrder() {

    }

    /**Change turn order when a round ends
     */
    public void switchTurnOrder(Player player) {
        while(turnQueue.get(0) != player){
            Player tempPlayer = turnQueue.remove(0);
            turnQueue.add(tempPlayer);
        }
    }

    @Override
    public void setPlayerTurnOrder() {
        Collections.shuffle(turnQueue);
    }

    /**Compare cards and return the lowest card
     * @param card1 first card to compare
     * @param card2 second card to compare
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getLesserCard(RankedCard<StandardPlayingCardRank> card1, RankedCard<StandardPlayingCardRank> card2) {
        if(cards.get(card1) >= cards.get(card2)) return card1;
        else return card2;
    }

    /**Compare cards and return the highest card
     * @param card1 first card to compare
     * @param card2 second card to compare
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getGreaterCard(RankedCard<StandardPlayingCardRank> card1, RankedCard<StandardPlayingCardRank> card2) {
        if(cards.get(card1) >= cards.get(card2)) return card1;
        else return card2;
    }

    /**
     * Get the lowest card in the deck
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getLowestCard() {
        RankedCard<StandardPlayingCardRank> lowestCard = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[1];
        for (int i = 1; i < cards.values().size(); i++){
            if ((Integer)cards.values().toArray()[i] < cards.get(lowestCard)){
                lowestCard = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[i];
            }
        }
        return lowestCard;
    }

    /**
     * Get the highest card in the deck
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank> getHighestCard() {
        RankedCard<StandardPlayingCardRank> highestCard = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[1];
        for (int i = 1; i < cards.values().size(); i++){
            if ((Integer)cards.values().toArray()[i] > cards.get(highestCard)){
                highestCard = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[i];
            }
        }
        return highestCard;
    }

    /**Get all cards with a lower value
     * @param card
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank>[] getCardsBelow(RankedCard<StandardPlayingCardRank> card) {
        RankedCard<StandardPlayingCardRank>[] cardsBelow = (RankedCard<StandardPlayingCardRank>[])new RankedCard[13];
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(cards.keySet().toArray()[i]) < cards.get(card)){
                cardsBelow[i] = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[i];
            }
        }
        return cardsBelow;
    }

    /**Get cards with a lower value
     * @param value
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank>[] getCardsBelow(Integer value) {
        RankedCard<StandardPlayingCardRank>[] cardsBelow = (RankedCard<StandardPlayingCardRank>[])new RankedCard[13];
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(cards.keySet().toArray()[i]) < value){
                cardsBelow[i] = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[i];
            }
        }
        return cardsBelow;
    }

    /**Get all cards with a higher value
     * @param card
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank>[] getCardsAbove(RankedCard<StandardPlayingCardRank> card) {
        RankedCard<StandardPlayingCardRank>[] cardsAbove = (RankedCard<StandardPlayingCardRank>[])new RankedCard[13];
        for(int i = cards.size(); i > 0; i--){
            if (cards.get(cards.keySet().toArray()[i]) < cards.get(card)){
                cardsAbove[i] = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[i];
            }
        }
        return cardsAbove;
    }

    /**Get all cards with a higher value
     * @param value
     * @return
     */
    @Override
    public RankedCard<StandardPlayingCardRank>[] getCardsAbove(Integer value) {
        RankedCard<StandardPlayingCardRank>[] cardsAbove = (RankedCard<StandardPlayingCardRank>[])new RankedCard[13];
        for(int i = cards.size(); i > 0; i--){
            if (cards.get(cards.keySet().toArray()[i]) < value){
                cardsAbove[i] = (RankedCard<StandardPlayingCardRank>) cards.keySet().toArray()[i];
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
