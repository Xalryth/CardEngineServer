package Factories;

/*
* @Author Peter C. Straarup 30/01-2019
* Generic interface for Factories
* */

public interface Factory<T> {
    T create(String name);
}
