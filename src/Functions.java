/**
 * @author: Philip Hansen
 * @date: 10-02-2019
 * @version 1.0
 */
import DTOs.UserDTO;
import Decks.CardComparator;
import Decks.Hand;
import Repositories.UserRepository;
import Rooms.Games.Whist.WhistGamemode;
import Users.Player;
import Users.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Vector;

public class Functions {

    WhistGamemode game = new WhistGamemode("Test");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addUser(){
        UserRepository a = new UserRepository();
        try {
            var test = new UserDTO("fName", "lName", "email", "username", "password", Date.valueOf(LocalDate.of(1967, 6, 22)));
            a.add(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** method to controll gameplay
     * @author Philip Hansen
     */
    public void playGame() throws IOException {
        //setup game

        //setup players
        Vector<User> players = new Vector<>();
        players.add(new User("p1"));
        players.add(new User("p2"));
        players.add(new User("p3"));
        players.add(new User("p4"));

        //start game round and get first player
        System.out.println("starting game");
        game.startGame(players);
        Player player = game.getCurrentPlayer();

        for (int i = 0; i < game.getPlayers().size();i++){
        //sort hand
        Collections.sort(game.getPlayers().get(i).getHand().getCards(),new CardComparator());
        }
        while(game.isRunning()){
            //get players cards
            Hand hand = player.getHand();

            System.out.println("Player " + player.getName() + "'s turn\n" +
                    "Current Score: " + player.getScore());

            if (game.getRoundCount() == 0){
                //display players cards
                System.out.println(displayHand(hand));
                callRound();
                if(game.getTurnCount() == 4){
                    game.getGameState().finalCall();
                }
            }
            else{
                System.out.println("Current pile\n" +
                        displayPile());

                System.out.println("play card");
                //display players cards
                System.out.println(displayHand(hand));
                boolean noCard = true;
                while (noCard){
                    try{
                        String sCard = br.readLine();
                        int card;
                        if (sCard == "" || sCard.isEmpty()||sCard.isBlank())card=1;
                        else card = Integer.parseInt(sCard);
                        if(game.playCard(hand.getCards().get(card - 1))) noCard = false;
                        else System.out.println("You have to match the played card rank");
                    }
                    catch (IndexOutOfBoundsException ex){
                        System.out.println("Card not found, please choose a card in your hand");
                    }
                }
            }
            player = game.endTurn();
            System.out.println("\n" +
                    "--------------------------------------------------------------------------\n" +
                    "");
        }
        game.endGame();
    }

    /**Display the pile to the user
     * @author Philip Hansen
     * @return the pile in string format
     */
    public String displayPile(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < game.getPile().size(); i++){
            sb.append(game.getPile().get(i).getIdentifyer().toString() + " " + game.getPile().get(i).getRank() + ", ");
        }
        return sb.toString();
    }
    /**Display the users hand to the user
     * @author Philip Hansen
     * @return the users hand in string format
     */
    public String displayHand(Hand hand){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hand.getCards().size(); i++) {
            sb.append((i+1) + ": " + hand.getCards().get(i).getIdentifyer().toString() +
                    hand.getCards().get(i).getRank().toString() + ",");
        }
        return sb.toString();
    }

    /**controller for the call round
     * @author Philip Hansen
     */
    public void callRound() throws IOException {
        //call round ----------
        int call;
        boolean noCall= true;
        System.out.println("Dit valg er ligemeget da den altid vil vælge pas\n" +
                "Call one of the fallowing");
        //make sure the player playes a card
        while (noCall) {
            System.out.print("1: " + game.getGameState().getAvalableCalls()[0]);
            for (int i = 1; i < game.getGameState().getAvalableCalls().length; i++) {
                System.out.print(", " + (i + 1) + ": " + game.getGameState().getAvalableCalls()[i]);
            }
            try{
                String sCard = br.readLine();
                if (sCard == "" || sCard.isEmpty()||sCard.isBlank())call=1;
                else call = Integer.parseInt(sCard);
                for (int i = 0; i < game.getGameState().getAvalableCalls().length; i++) {
                    if (call == game.getGameState().getAvalableCalls()[i].ordinal() + 1) {
                        noCall = false;
                        game.call(game.getGameState().getAvalableCalls()[i]);
                        break;
                    }
                }
            }
            catch (IndexOutOfBoundsException ex){
                System.out.println("Card not found, please choose a card in your hand");
            }
            if (noCall){
                System.out.println("not a valid call");
                System.out.println("Please call one of the fallowing");
            }
        }
    }
}
