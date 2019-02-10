/**
 * @author: Philip Hansen, Rasmus Rosenkjær
 * @date: 04-02-2019
 * @version 1.0
 */
package Rooms.Games.Whist;

import Cards.RankedCard;
import Cards.StandardPlayingCardRank;
import Decks.Deck;
import Decks.Hand;
import Decks.Managables.Deckable;
import Managers.RoundManager;
import Managers.TurnManager;
import Rooms.Games.Game;
import Users.Player;
import Users.User;

import java.util.*;

import static javax.swing.UIManager.getString;

public class WhistGamemode extends Game implements TurnManager, Deckable<RankedCard<StandardPlayingCardRank>>,
        RoundManager {

    int turnCount = 0;
    int roundCount = 0;
    Vector<Player> turnQueue = new Vector<>();
    boolean isClockwise = true;



    /**The deck to deal cards from
     */
    Deck<RankedCard<StandardPlayingCardRank>> deck;
    /**The game pile
     */
    Vector<RankedCard<StandardPlayingCardRank>> pile = new Vector<>();
    WhistState[] gameStates = {new WhistPassState(),new WhistGrandState(), new WhistSolState(), new WhistGrandiState()};
    WhistState gameState = gameStates[0];
    protected StandardPlayingCardRank trumf;

    public WhistGamemode(String name) {
        super(name);
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Vector<RankedCard<StandardPlayingCardRank>> getPile() {
        return pile;
    }

    @Override
    public Player endRound() {
            Player winningPlayer = turnQueue.get(0);
        if(roundCount != 0){
            //Figure out what card wins
            RankedCard<StandardPlayingCardRank> winningCard = pile.get(0);
            for (int i = 1; i < pile.size();i++){
                if(winningCard != gameState.getGreaterCard(winningCard, pile.get(i))){
                    winningPlayer = turnQueue.get(i);
                    winningCard = gameState.getGreaterCard(winningCard, pile.get(i));
                }
            }
            //give points to the winning player
            winningPlayer.setScore((short)(winningPlayer.getScore() + 1));
        }
        else{
            winningPlayer = gameState.players.firstElement();
        }
        getTurnOrdet(winningPlayer);
        if(winningPlayer.getHand().getCards().isEmpty()){
            setGameStarted(false);
        }
        /**
         * du ville normalt sætte alle printLn i gui laget men pga tidspræs et det sat her
         */
        System.out.println("Winning player: " + winningPlayer.getName());
        pile.removeAllElements();
        return winningPlayer;
    }

    /**Set the deck used in the game
     * @return
     */
    public Deck<RankedCard<StandardPlayingCardRank>> createDeck() {
        Deck<RankedCard<StandardPlayingCardRank>> tempDeck = new Deck<>();
        //Check if there is a set of cards to use
        if(gameState.cards.isEmpty()){
            gameState.setCards();
        }
        tempDeck.setCards(new Vector<>(Collections.list(gameState.cards.keys())));
        return tempDeck;
    }

    public WhistState getGameState() {
        return gameState;
    }

    /**A method to call the type of game for this round
     * @param call
     */
    public  void call(WhistCalls call){
        switch (call){
            case pas: gameState = gameStates[0];
            break;
            case sol: gameState = gameStates[1];
            break;
            case grandi: gameState = gameStates[2];
            break;
            case grand: gameState = gameStates[3];
        }
        //send call to other players
    }

    /**A method to play a cretan card
     * @param card
     */
    public boolean playCard(RankedCard<StandardPlayingCardRank> card){

        boolean isReanon = true;
        //see if the player is renon in the chosen rank
        if(!pile.isEmpty()) {
            for (int i = 0; i < getCurrentPlayer().getHand().getCards().size(); i++) {
                if (getCurrentPlayer().getHand().getCards().get(i).getRank() == pile.get(0).getRank()) {
                    isReanon = false;
                    break;
                }
            }
        }
        //make sure the player can play the card
        if(getCurrentPlayer().getHand().getCards().contains(card) &&
                (pile.isEmpty() || isReanon || pile.get(0).getRank() == card.getRank())){
            pile.add(card);
            getCurrentPlayer().getHand().getCards().remove(card);
            return true;
        }
        return false;
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
        for (int i = 0; i < getPlayers().size(); i++){
            getPlayers().get(i).getHand().setCards(hands.get(i));
        }
    }

    /**Change turn order when a round ends
     */
    public void getTurnOrdet(Player player) {
        while(turnQueue.get(0) != player){
            Player tempPlayer = turnQueue.remove(0);
            turnQueue.add(tempPlayer);
        }
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
            Player tempPlayer = new Player(users.get(i).getName());
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

    @Override
    public void endGame() {
        gameState.dealPoints(getPlayers());
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
        return getTurnQueue().get(turnCount - 1);

    }

    @Override
    public Player endTurn() {
        //if all players have played a card go into the next round
        if(turnCount == 4) {
            roundCount++;
            turnCount = 0;
            //if it is not call round
            if(roundCount != 1){
                turnCount++;
                return endRound();
            }
        }
        turnCount++;
        return getTurnQueue().get(turnCount - 1);
    }

    @Override
    public void switchTurnOrder() {

    }

    @Override
    public void setPlayerTurnOrder() {
        Collections.shuffle(turnQueue);
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
