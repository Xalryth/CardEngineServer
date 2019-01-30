/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package EndPoints;


import Handlers.DataHandler;
import Handlers.MessageHandler;

import javax.json.JsonObject;
import java.net.URI;
import java.util.Map;

public class ClientEndpoint<T> implements WebsocketEndPoint, DataHandler, MessageHandler {
    private T session;
    public ClientEndpoint(URI uri){
    }

    public T getSession() {
        return session;
    }

    public void setSession(T session) {
        this.session = session;
    }

    @Override
    public void onOpen(Object session) {

    }

    @Override
    public void onClose(Object session) {

    }

    @Override
    public void onMessage(String message, Object session) {

    }

    // bullshit -Peter
    //JsonObject er en del af glassfish og der vil derfor komme en fejl
    //så længe at glassfish ikke er instaleret på computeren
    //@java.lang.Override
    //public void sendMessage(JsonObject jsonObject) {

    //}

    @java.lang.Override
    public void addMessageHandler(MessageHandler handler) {

    }

    @Override
    public Object decodeMessage(String message) {
        return null;
    }

    @Override
    public Object encodeMessage(Map message) {
        return null;
    }

    @Override
    public void handleMessage(String message) {

    }
}
