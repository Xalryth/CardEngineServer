package Rooms.Lobbies;

import Rooms.Games.Game;
import Users.User;

import java.util.Map;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public class Lobby {
    private int id;
    private Map<User, Boolean> users;
    private Game game;

    public Lobby(int id, User user, Game game){
        this.id = id;
        this.users.put(user, false);
        this.game = game;
    }

    public Map<User, Boolean> getUsers(){
        return this.users;
    }

    public void addUser(User user){
        this.users.put(user, false);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public Game getGame(){
        return this.game;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public int getId(){
        return this.id;
    }
}
