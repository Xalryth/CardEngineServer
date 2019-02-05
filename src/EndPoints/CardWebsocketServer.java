/**
 * @author Philip Hansen
 * @version 0.1
 * @since 30-01-2019
 */

package EndPoints;

import Handlers.DataHandler;
import Handlers.MessageHandler;
import Logging.LogType;
import Logging.Loggable;

import javax.json.JsonObject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint("/ws")
public class CardWebsocketServer extends ServerEndPoint<Session, URI> implements Loggable, WebsocketEndPoint<Session>, MessageHandler, DataHandler {
    public CardWebsocketServer(URI uri) {
    }

    @Override
    public void start(URI param) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, param);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @OnOpen
    public void onOpen(Session session) {
        connections.add(session);
    }

    @Override
    @OnClose
    public void onClose(Session session) {
        connections.remove(session);
    }

    @Override
    @OnMessage
    public void onMessage(String message, Session session) {
        Map claim = new HashMap();

        //Create user
        claim.put("action", 1);

        claim.get(1);
        var temp = claim.get(1);
        if (temp == "Action"){

        }

        int messageRec = 1;

        switch (messageRec) {
            case 1:
                break;
            default:
                break;
        }
    }

    @Override
    public void sendMessage(JsonObject jsonObject) {

    }

    @Override
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

    @Override
    public void log() {
    }

    @Override
    public void log(LogType logType) {
    }
}
