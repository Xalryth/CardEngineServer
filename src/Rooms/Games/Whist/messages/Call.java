package Rooms.Games.Whist.messages;

import Rooms.Games.Whist.WhistCalls;

public class Call {

    WhistCalls call;

    public Call(WhistCalls calls){
        call = calls;
    }

    public Call(String message){

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
