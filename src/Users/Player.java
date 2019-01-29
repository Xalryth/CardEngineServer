package Users;

import Decks.Hand;

public class Player {
        private Hand hand;
        private short score;

        public Player(){
        }

        public Player(Hand hand){
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
