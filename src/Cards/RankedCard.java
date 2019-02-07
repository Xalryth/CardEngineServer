package Cards;

/*
 *   @Author Rasmus Rosenkjær
 *   @Date 29-01-2019
 */

//Interface for the rankedcards
public class RankedCard<T> extends Card<Object>{
    T rank;

    public T getRank() {
        return rank;
    }
    public void setRank(T rank) {
        this.rank = rank;
    }
    public RankedCard(T rank,Object identifyre){
        super(identifyre);
        this.rank = rank;
    }
}
