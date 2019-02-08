package Rooms.Games.Whist;

import Users.Player;

import java.util.Vector;

public class WhistState {

    WhistCalls[] avalableCalls = {WhistCalls.pas,WhistCalls.grand,WhistCalls.grandi,WhistCalls.sol};
    public WhistCalls finalCall(){
        return WhistCalls.pas;
    }
    public void dealPoints(Vector<Player> players){
        Vector<Player> playerRanking = new Vector<>();
        playerRanking.add(players.get(0));
        //figure out who won
        for (int i = 1; i < players.size();i++){
            for (int j = 0; j < playerRanking.size(); j++){
                if(players.get(i).getScore() <= players.get(j).getScore()){
                    playerRanking.insertElementAt(players.get(i),j);
                }
            }
            if(playerRanking.size()!= i+1){
                playerRanking.add(players.get(i));
            }
        }
        if(playerRanking.get(0).getScore() == playerRanking.get(1).getScore()){

            if(playerRanking.get(1).getScore() == playerRanking.get(2).getScore()){

            }
        }
    }

}
