package Rooms.Games.Whist;
/**
 * @author: Philip Hansen
 * @date: 10-02-2019
 * @version 1.0
 */
import Users.Player;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Vector;

public class WhistSolState extends WhistState {

    @Override
    void setAvalableCalls() {
        avalableCalls = new WhistCalls[]{WhistCalls.pas, WhistCalls.sol, WhistCalls.grandi};
    }

    @Override
    public WhistCalls finalCall() {
        for(int i = 0; i< cards.size(); i ++){
            if ((int)(new Vector<>(Collections.list(cards.keys()))).get(i).getIdentifyer() == 1){
                alterCardValue((new Vector<>(Collections.list(cards.keys()))).get(i),1);
            }
        }
        return WhistCalls.sol;
    }

    @Override
    public void dealPoints(Vector<Player> players) {

    }
}
