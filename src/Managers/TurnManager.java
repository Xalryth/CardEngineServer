package Managers;

import Users.Player;

import java.util.Vector;

interface  TurnManager {
    //TODO Peter kig her
    int turnCount = 0;
    Vector<Player> turnQueue = new Vector<Player>();
    boolean isClockwise = true;

    int getTurnCount();
    Player[] getTurnQueue();
    Player getCurrentPlayer();
    Player endTurn();
    void switchTurnOrder();
    void setPlayerTurnOrder();
}
