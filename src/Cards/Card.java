package Cards;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Class for a simple card
public abstract class Card{

    private boolean faceup = false;

    public boolean getFaceup() {
        return faceup;
    }
    public void setFaceup(boolean faceup) {
        this.faceup = faceup;
    }

    void flipCard(){

    }

}
