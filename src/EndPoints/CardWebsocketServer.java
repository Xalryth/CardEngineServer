/**
 * @author Philip Hansen
 * @version 0.1
 * @since 30-01-2019
 */

package EndPoints;

import Handlers.DataHandler;
import Handlers.MessageHandler;
import Handlers.Service.StandardUserService;
import Logging.LogType;
import Logging.Loggable;
import Users.User;

import javax.json.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import java.net.URI;
import java.util.*;

@ServerEndpoint("/ws")
public class CardWebsocketServer extends ServerEndPoint<Session, URI> implements Loggable, WebsocketEndPoint<Session>, MessageHandler, DataHandler<JsonObject> {
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
        JsonObject jsonObj = handleMessage(message, session);
        session.getAsyncRemote().sendObject(jsonObj);
    }

    @Override
    public void sendMessage(JsonObject jsonObject) {
    }

    /**
     * @author Christoffer Pietras
     * @version 1
     * @since 07-02-2019
     */
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

        for (String entry : message.keySet()) {
            obj.add(entry, message.get(entry).toString());
        }

        return obj.build();
    }

    /**
     * @author Christoffer Pietras
     * @version 1
     * @since 07-02-2019
     */
    @Override
    public JsonObject handleMessage(String message, Session session) {
        JsonObject jsonObj = decodeMessage(message);
        PacketType type = PacketType.values()[jsonObj.getJsonObject("array").getInt("type")];
        JsonObject content = jsonObj.getJsonObject("array").getJsonObject("content");
        Map claim = new HashMap();

        StandardUserService uService = new StandardUserService();

        switch (type) {
            case CreateUser:
                try {
                    JsonArray jsonArray = content.getJsonArray("users");
                    claim = uService.createUsers(jsonArray, PacketType.CreateUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case UpdateUser:
                try {
                    JsonArray jsonArray = content.getJsonArray("users");
                    claim = uService.updateUsers(jsonArray, PacketType.UpdateUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case RemoveUser:
                try {
                    JsonArray jsonArray = content.getJsonArray("users");
                    claim = uService.RemoveUsers(jsonArray, PacketType.RemoveUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ResetPasswordUser:
                try {
                    JsonArray jsonArray = content.getJsonArray("users");
                    claim = uService.ResetPasswordUsers(jsonArray, PacketType.ResetPasswordUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case UserLogin:
                try {
                    JsonArray jsonArray = content.getJsonArray("users");
                    claim = uService.login(jsonArray, PacketType.UserLogin);
                    session.getUserProperties().put("username", claim.get("username"));
                    connections.add(session);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return encodeMessage(claim);
    }

    @Override
    public void log() {
    }

    @Override
    public void log(LogType logType) {
    }

}
