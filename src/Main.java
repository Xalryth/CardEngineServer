import Cards.RankedCard;
import DTOs.UserDTO;
import Decks.CardComparator;
import Decks.Hand;
import Repositories.UserRepository;
import Rooms.Games.Whist.WhistCalls;
import Rooms.Games.Whist.WhistGamemode;
import Users.Player;
import Users.User;
/**
 * @author: Philip Hansen, Christoffer Pietra
 * @date: 10-02-2019
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Main<ststic> {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Functions functions = new Functions();
        System.out.println("select method\n" +
                "1: add a user to database(needs database setup)\n" +
                "2: play game");
        switch (br.readLine()){
            case "1":
                 functions.addUser();
            case "2":functions.playGame();
        }
        System.out.println("End of the program");
        br.readLine();
    }

}