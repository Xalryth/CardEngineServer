package Rooms.Games.Whist;
/**
 * @author: Philip Hansen
 * @date: 10-02-2019
 * @version 1.0
 */
import Users.Player;

import java.util.Collections;
import java.util.Vector;

public class WhistPassState extends WhistState {
    @Override
    void setAvalableCalls() {
        avalableCalls = new WhistCalls[]{WhistCalls.pas, WhistCalls.grand, WhistCalls.sol, WhistCalls.grandi};
    }

    /**set the settings for this gamemode
     * @author Philip Hansen
     * @return the last made call
     */
    public WhistCalls finalCall(){
        for(int i = 0; i< cards.size(); i ++){
            if ((int)(new Vector<>(Collections.list(cards.keys()))).get(i).getIdentifyer() == 1){
                alterCardValue((new Vector<>(Collections.list(cards.keys()))).get(i),14);
            }
        }
        return WhistCalls.pas;
    }

    /**
     * deal points to the winning players
     * @param players The players playing the game
     * @author Philip Hansen
     */
    public void dealPoints(Vector<Player> players){
        Vector<Player> playerRanking = new Vector<>();
        playerRanking.add(players.get(0));
        //sort the players from least to most opints
        for (int i = 1; i < players.size();i++){
            int playerPosition = -1;
            for (int j = 0; j < playerRanking.size(); j++){
                if(players.get(i).getScore() <= playerRanking.get(j).getScore()){
                    playerPosition = j;
                }
            }
            if(playerPosition != -1)
                playerRanking.insertElementAt(players.get(i),playerPosition);
            else
                playerRanking.add(players.get(i));

        }

        /**
         * du ville normalt sætte alle printLn i gui laget men pga tidspræs et det sat her
         */
        //Deal points
        if(playerRanking.get(0).getScore() == playerRanking.get(1).getScore()){
            if(playerRanking.get(1).getScore() == playerRanking.get(2).getScore()){
                System.out.println("player " + playerRanking.get(0).getName() +", " + playerRanking.get(1).getName() +", and "
                        + playerRanking.get(2).getName() +" get 1 point while player " + playerRanking.get(0).getName() +
                        " get -3 points");
            }
            System.out.println("player " + playerRanking.get(0).getName() +", and "
                    + playerRanking.get(1).getName() +" get 1 point while player " + playerRanking.get(2).getName() + ", and " +
                    playerRanking.get(3).getName() +" get -1 point");
        }
    else
        System.out.println("player " + playerRanking.get(0).getName() +" get 3 points while player " +
                playerRanking.get(1).getName() + ", " + playerRanking.get(2).getName() + " and " +
                playerRanking.get(3).getName() +" get -1 point");
    }
}
