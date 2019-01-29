package Cards;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Interface for a simple card
public interface Card{
    boolean faceup = false;

    void flipCard();
    boolean getFaceUp();
    void setFaceUp(Boolean setFaceUpBool);
}
