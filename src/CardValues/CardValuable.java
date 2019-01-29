package CardValues;

//TODO Peter kig her


public interface CardValuable {
    Hashtable<K, V> getCardValues();
    void setCardValues(Hashtable<K, V>);
    void addCardValuePair(K, V);
    void alterCardValue(K, V);
    void removeCardValuePair(K);
}
