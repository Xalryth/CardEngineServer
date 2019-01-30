package Cards;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Interface for the rankedcards
public class RankedCard<T> extends Card{
    T rank;

    public T getRank() {
        return rank;
    }
    public void setRank(T rank) {
        this.rank = rank;
    }
    public RankedCard(T rank){
        this.rank = rank;
    }
}
