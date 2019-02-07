package Managers;

import Users.Player;
import java.util.Vector;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public interface TurnManager {

    int getTurnCount();
    Vector<Player> getTurnQueue();
    Player getCurrentPlayer();
    Player endTurn();
    void switchTurnOrder();
    void setPlayerTurnOrder();
}
