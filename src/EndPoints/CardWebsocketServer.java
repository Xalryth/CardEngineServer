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

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import java.net.URI;
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
        //Recevice json string
        JsonObject jsonobj = decodeMessage(message);
        int type = jsonobj.getJsonObject("array").getInt("type");
        String content = jsonobj.getJsonObject("array").getString("content");

        switch (type) {
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
    public JsonObject decodeMessage(String message) {
        JsonReader jsonReader = Json.createReader(new StringReader(message));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        return jsonObject;
    }

    @Override
    public JsonObject encodeMessage(Map message) {
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
