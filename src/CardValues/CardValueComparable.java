package CardValues;

//TODO Peter kig her
public interface CardValueComparable {
    K getLesserCard(K, K);
    K getGreaterCard(K, K);
    K getLowestCard(K);
    K getHighestCard(K);
    K[] getCardsBelow(K);
    K[] getCardsBelow(V);
    K[] getCardsAbove(K);
    K[] getCardsAbove(V);
}
