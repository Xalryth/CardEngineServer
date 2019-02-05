package Decks;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//The class for the hand
public class Hand extends Deck {

    int cardLimit;

    //properties for getCardLimit
    public int getCardLimit() {
        return cardLimit;
    }
    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    //default constructor
    public Hand(){

    }

    //constructor with a cardlimit
    public Hand(int cardLimit){

    }

    //Method to sort the hand uses CardSortType Enum
    public void sortHand(CardSortType sortType){

    }
}