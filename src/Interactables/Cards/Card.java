package Interactables.Cards;

/*
* @Author Peter C. Straarup 28/01-2019
* Base class for the Card object,
* which is extended upon to fulfill the requirements of other card types
* */
public abstract class Card {
    Boolean faceUp;

    public Card(){ }
    public Card(Boolean faceUp){ this.faceUp = faceUp; }

    public Boolean getFaceUp(){ return faceUp; }
    public void setFaceUp(Boolean value){ faceUp = value; }
    public void flipCard(){ faceUp = !faceUp; }
}
