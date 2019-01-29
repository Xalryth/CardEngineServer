package Rooms.Lobbies;

import Users.Player;
import Users.User;

import java.util.Vector;

public class Game {

    private String name;
    private Vector<Player> players;
    private byte[] legalSetups;
    private Boolean gameStarted;

    public Game(String name){
        this.name = name;
    }

    //TODO StartGame
    public void startGame(User[] users){
    }

    //TODO EndGame
    public void endGame(){
    }

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
