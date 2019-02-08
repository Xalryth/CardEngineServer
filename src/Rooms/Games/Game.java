package Rooms.Games;

import Users.Player;

import java.util.Vector;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public abstract class Game {

    private String name;
    private Vector<Player> players;
    private Vector<User> spectators;
    private byte[] legalSetups;
    private Boolean gameStarted;

    public Game(String name){
        this.name = name;
    }

    public abstract void startGame(Vector<User> users);

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

    public Vector<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Vector<Player> players) {
        this.players = players;
    }

    public Boolean getGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(Boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
}
