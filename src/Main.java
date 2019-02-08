import Cards.RankedCard;
import Cards.StandardPlayingCardRank;
import DTOs.UserDTO;
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
import java.util.Vector;

public class Main<ststic> {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select method");
        switch (br.readLine()){
            case "1":addUser();
            case "2":playGame();
        }
    }
    public static void addUser(){
        UserRepository a = new UserRepository();
        try {
            var test = new UserDTO("fName", "lName", "email", "username", "password", Date.valueOf(LocalDate.of(1967, 6, 22)));
            a.add(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void playGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //setup game
        WhistGamemode game = new WhistGamemode("Test");

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
        //sort hand

        //call round ----------
        //display players cards
        StringBuilder sb = new StringBuilder();
        Hand hand = player.getHand();
        for (int i = 0; i < hand.getCards().size(); i++){
            sb.append(hand.getCards().get(i).getIdentifyer().toString() +
                    hand.getCards().get(i).getRank().toString() + ",");
        }
        br.readLine();
    }
}