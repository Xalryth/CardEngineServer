package Factories;

import Rooms.Games.Game;

/*
* @Author Peter C. Straarup 30/01-2019
* Factory for producing instances of the game class
*/

public class GameFactory implements Factory<Game>{
    public GameFactory(){ }

    public Game create(String name){ return null; }
}
