package Rooms.Games;

import Users.Player;
import Users.User;

import java.util.Vector;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public abstract class Game {

    private String name;
    private Vector<Player> players;
    private byte[] legalSetups;
    private Boolean gameStarted;

    public Game(String name){
        this.name = name;
    }

    public abstract void startGame(User[] users);

    public abstract void endGame();

    public String getName(){
        return this.name;
    }

    public byte[] getLegalSetups(){
        return this.legalSetups;
    }

    public void setLegalSetups(byte[] legalSetups){
        this.legalSetups = legalSetups;
    }

    public boolean isRunning(){
        return this.gameStarted;
    }

}
