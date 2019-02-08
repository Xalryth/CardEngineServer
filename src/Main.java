import DTOs.UserDTO;
import Repositories.UserRepository;
import Rooms.Games.Whist.WhistGamemode;
import Users.Player;

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
    public static void playGame(){
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
        Player player = game.startGame(players);
        //sort hand

        //call round ----------
        //display players cards
        StringBuilder sb = new StringBuilder();
    }
}