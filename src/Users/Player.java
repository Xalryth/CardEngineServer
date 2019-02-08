package Users;

import Decks.Hand;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public class Player extends User{
        private Hand hand;
        private short score;

        public Player(String name){
            super(name);
        }

        public Player(String name, Hand hand){
            super(name);
            this.hand = hand;
        }

        public Hand getHand(){
            return this.hand;
        }

        public void setHand(Hand hand){
            this.hand = hand;
        }

        public short getScore(){
            return this.score;
        }

        public void setScore(short score){
            this.score = score;
        }

    }
