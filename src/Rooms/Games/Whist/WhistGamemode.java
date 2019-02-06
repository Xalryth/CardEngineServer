/**
 * @author: Philip Hansen, Rasmus Rosenkjær
 * @date: 04-02-2019
 * @version 1.0
 */
package Rooms.Games.Whist;

import Cards.Card;
import Decks.Deck;
import EndPoints.CardWebsocketServer;
import Managers.TurnManager;
import Rooms.Games.Game;
import Rooms.Games.Whist.messages.Call;
import Rooms.Games.Whist.messages.PlayCard;
import Rooms.Games.Whist.messages.SendHand;
import Users.Player;
import Users.User;

import java.util.Collections;
import java.util.Vector;

public class WhistGamemode extends Game implements TurnManager {

    WhistCalls[] whistCalls= new WhistCalls[4];
    Deck<Card> deck;
    CardWebsocketServer cardWebsocketServer;

    public WhistGamemode(String name) {
        super(name);
    }

    @Override
    public void startGame(User[] users) {
        if (!(users.length >= 4)) throw new ArrayStoreException("Too Many Players");
        Vector<Player> players = new Vector<Player>();
        for (int i = 0; i< users.length; i++){
            Player tempPlayer = new Player(users[i]);
            players.add(tempPlayer);
            turnQueue.add(tempPlayer);
        }
        setPlayers(players);
        setGameStarted(true);
        setPlayerTurnOrder();
        SendHands();
    }

    //A method to call the type of game for this round
    public void Call(Message<Call> message){
        //Check if call is valid
        //send call to other players
    }

    //A method to play a cretan card
    public void PlayCard(Message<PlayCard> message){
        //Check if card is valid
        //Check if player has the played card
        //Play the card
    }

    //A method to send a new hand to all players
    public void SendHands(){
        Vector<Vector<Card>> hands = new Vector<Vector<Card>>();
        Vector<Card> cards = deck.getCards();
        Collections.shuffle(cards);
        for(int i = 0; i < cards.size();i++){
            hands.get(0).add(cards.get(i));
            if (hands.get(0).size() == 13){
                Message<SendHand> handMessage = new Message<SendHand>();
                handMessage.setMessage(new SendHand(hands.get(0)));
                //Send hand to other players
                hands.remove(0);
            }
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
        int currentRound = (int) Math.ceil(turnCount / 4.0);
        int index = turnCount - ((currentRound - 1) * 4);
        if (index == 5) index = 1;
        return getPlayers().get(index - 1);
    }

    @Override
    public void switchTurnOrder() {

    }

    @Override
    public void setPlayerTurnOrder() {
        Collections.shuffle(turnQueue);
    }

}
