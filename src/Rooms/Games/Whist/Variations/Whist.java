package Rooms.Games.Whist.Variations;
/**
 * @author: Philip Hansen
 * @date: 10-02-2019
 * @version 1.0
 */
import Rooms.Games.Whist.WhistGamemode;
import Users.User;

import java.util.Vector;

public class Whist extends WhistGamemode {
    public Whist(String name) {
        super(name);
    }

    @Override
    public void startGame(Vector<User> users) {
        super.startGame(users);
    }
}
