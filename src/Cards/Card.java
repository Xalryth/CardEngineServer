package Cards;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Class for a simple card
public abstract class Card<T>{

    T identifyer;

    public Card(){

    }
    public Card(T identifyer){
        this.identifyer = identifyer;
    }

    public T getIdentifyer() {
        return identifyer;
    }

    public void setIdentifyer(T identifyer) {
        this.identifyer = identifyer;
    }
}
