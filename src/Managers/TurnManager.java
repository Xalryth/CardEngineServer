package Managers;

import Users.Player;
import java.util.Vector;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public interface TurnManager {
    int turnCount = 0;
    Vector<Player> turnQueue = new Vector<>();
    boolean isClockwise = true;

    int getTurnCount();
    Vector<Player> getTurnQueue();
    Player getCurrentPlayer();
    Player endTurn();
    void switchTurnOrder();
    void setPlayerTurnOrder();
}
