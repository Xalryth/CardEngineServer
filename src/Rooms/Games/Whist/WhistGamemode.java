/**
 * @author: Philip Hansen, Rasmus Rosenkjær
 * @date: 04-02-2019
 * @version 1.0
 */
package Rooms.Games.Whist;

import CardValues.CardValueComparable;
import Cards.RankedCard;
import Cards.StandardPlayingCardRank;
import Decks.Deck;
import Decks.Hand;
import Decks.Managables.Deckable;
import EndPoints.CardWebsocketServer;
import Managers.TurnManager;
import Rooms.Games.Game;
import Users.Player;

import java.util.*;

import static javax.swing.UIManager.getString;

public class WhistGamemode extends Game implements TurnManager, Deckable<RankedCard<StandardPlayingCardRank>>,
        CardValueComparable<RankedCard<StandardPlayingCardRank>,Integer> {

    int turnCount = 0;
    int roundCount = 0;
    Vector<Player> turnQueue = new Vector<>();
    boolean isClockwise = true;



    /**the deck of cards used in the game
     */
    Hashtable<RankedCard<StandardPlayingCardRank>,Integer> cards = new Hashtable<>();
    /**The deck to deal cards from
     */
    Deck<RankedCard<StandardPlayingCardRank>> deck;
    /**The game pile
     */
    Vector<RankedCard<StandardPlayingCardRank>> pile;
    WhistState[] gameStates = {new WhistState()};
    WhistState gameState = new WhistState();
    CardWebsocketServer cardWebsocketServer;
    protected StandardPlayingCardRank trumf;

    public WhistGamemode(String name) {
        super(name);
    }

    @Override
    public void shuffleDeck() {
        Collections.shuffle(deck.getCards());
    }

    @Override
    public boolean searchDeck(RankedCard<StandardPlayingCardRank> searchDeck) {
        if (deck.getCards().contains(searchDeck)) return true;
        else return false;
    }

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

    /**Set the deck used in the game
     * @return
     */
    public Deck<RankedCard<StandardPlayingCardRank>> createDeck() {
        Deck<RankedCard<StandardPlayingCardRank>> tempDeck = new Deck<>();
        if(cards.isEmpty()){
            setCards();
        }
        tempDeck.setCards(new Vector<>(Collections.list(cards.keys())));
        return tempDeck;
    }

    @Override
    public void discardCards(RankedCard<StandardPlayingCardRank> discardCards) {

    }

    @Override
    public void startGame(Vector<User> users) {
        //Make sure all spots are filled
        if (!(users.size() == 4)) throw new ArrayStoreException("Player count dont match the required amount of 4 players");
        //set players
        Vector<Player> players = new Vector<>();
        for (int i = 0; i< users.size(); i++){
            Player tempPlayer = new Player(users.get(i));
            players.add(tempPlayer);
            turnQueue.add(tempPlayer);
        }
        setPlayers(players);
        deck = createDeck();
        turnCount++;
        setGameStarted(true);
        setPlayerTurnOrder();
        dealHands();
    }

    /**A method to call the type of game for this round
     * @param call
     */
    public  void call(WhistCalls call){
        switch (call){
            case pas: gameState = gameStates[0];
            //case sol: gameState = //sol implementation
            //case grandi:
            //case grand:
        }
        //send call to other players
    }

    /**A method to play a cretan card
     * @param card
     */
    public void playCard(RankedCard<StandardPlayingCardRank> card){
        if(getCurrentPlayer().getHand().getCards().contains(card)){
            pile.add(card);
        }
    }

    /**A method to send a new hand to all players
     */
    public void dealHands(){
        for (int i = 0; i < getPlayers().size();i++){
            getPlayers().get(i).setHand(new Hand(13));
        }
        shuffleDeck();
        int player = 0;
        Vector<Vector<RankedCard<StandardPlayingCardRank>>> hands = new Vector<>();
        hands.add(new Vector<>());
        hands.add(new Vector<>());
        hands.add(new Vector<>());
        hands.add(new Vector<>());
        while (deck.getCards().size()!= 0){
            hands.get(player).add(deck.getCards().remove(0));
            player += 1;
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
        RankedCard<StandardPlayingCardRank> winningCard = pile.get(0);
        Player winningPlayer = turnQueue.get(0);
        for (int i = 1; i < pile.size();i++){
            if(winningCard != getGreaterCard(winningCard, pile.get(i))){
                winningPlayer = turnQueue.get(i);
                winningCard = getGreaterCard(winningCard, pile.get(i));
            }
        }
        winningPlayer.setScore((short)(winningPlayer.getScore() + 1));
        switchTurnOrder(winningPlayer);
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
    public RankedCard<StandardPlayingCardRank> getLesserCard(RankedCard<StandardPlayingCardRank> card1,
                                                             RankedCard<StandardPlayingCardRank> card2) {
        if(cards.get(card1) >= cards.get(card2)) return card1;
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
        if(cards.get(card1) >= cards.get(card2)) return card1;
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

    @Override
    public Object draw(int draw) {
        return null;
    }

    @Override
    public void addToDeck(Object addToDeck, int addNumber1, int addNumber2) {

    }

    @Override
    public Object peek(int peekNumber1, int peekNumber2) {
        return null;
    }

    @Override
    public Object[] peek(int peekArrayNumber1, int peekArrayNumber2, int peekArrayNumber3) {
        return new Object[0];
    }

    @Override
    public Object[] searchDeck(Object searchDeck, int searchDeckNumber, boolean searchDeckBoolean) {
        return new Object[0];
    }

    @Override
    public Object discardCard(Object discardCard, int discardCardNumber) {
        return null;
    }

    @Override
    public Object[] discardCard(Object discardArrayCard) {
        return new Object[0];
    }
}
