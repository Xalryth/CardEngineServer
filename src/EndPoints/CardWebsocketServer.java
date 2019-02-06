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

import javax.json.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import java.net.URI;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@ServerEndpoint("/ws")
public class CardWebsocketServer extends ServerEndPoint<Session, URI> implements Loggable,WebsocketEndPoint<Session>, MessageHandler, DataHandler<JsonObject> {
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

    /*
    * @Author Peter C. Straarup 6/2-2019
    * Encodes claims into a json object and returns the object
    * */

    @Override
    public JsonObject encodeMessage(Map<String, Object> message) {
        JsonObjectBuilder obj = Json.createObjectBuilder();

        for(String entry : message.keySet()){
            obj.add(entry, message.get(entry).toString());
        }

        return obj.build();
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
