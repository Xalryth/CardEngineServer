package Managers;
/**
 * @author: Philip Hansen
 * @date: 10-02-2019
 * @version 1.0
 */
import Users.Player;

public interface RoundManager {
    int getRoundCount();
    Player endRound();

}
