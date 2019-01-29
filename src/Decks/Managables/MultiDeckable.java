package Decks.Managables;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Interface for the games that use more than one deck
public interface MultiDeckable<T> {
    T draw(int draw);
    void addToDeck(T addToDeck ,int addNumber1,int addNumber2);
    T peek(int peekNumber1,int peekNumber2);
    T[] peek(int peekArrayNumber1,int peekArrayNumber2,int peekArrayNumber3);
    T[] searchDeck(T searchDeck,int searchDeckNumber, boolean searchDeckBoolean);
    T discardCard(T discardCard, int discardCardNumber);
    T[] discardCard(T discardArrayCard);
}
