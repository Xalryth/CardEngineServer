/**
 * @author Philip Hansen
 * @version 0.1
 * @since 30-01-2019
 */

package EndPoints;

import DTOs.UserDTO;
import Handlers.DataHandler;
import Handlers.MessageHandler;
import Logging.LogType;
import Logging.Loggable;
import Repositories.UserRepository;

import javax.json.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        JsonObject jsonObj = handleMessage(message);
        session.getAsyncRemote().sendObject(jsonObj);
    }

    private Date stringToDate(String sDate) {
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date = sdf1.parse(sDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            return sqlStartDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void sendMessage(JsonObject jsonObject) {
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

        for (String entry : message.keySet()) {
            obj.add(entry, message.get(entry).toString());
        }

        return obj.build();
    }

    @Override
    public JsonObject handleMessage(String message) {
        JsonObject jsonobj = decodeMessage(message);
        PacketType type = PacketType.values()[jsonobj.getJsonObject("array").getInt("type")];
        JsonObject content = jsonobj.getJsonObject("array").getJsonObject("content");
        Map claim = new HashMap();

        switch (type) {
            case CreateUser:
                try {
                    UserRepository userRepository = new UserRepository();
                    JsonArray value = content.getJsonArray("users");
                    List<UserDTO> users = new Vector<>();

                    value.forEach(item -> {
                        JsonObject obj = (JsonObject) item;
                        String fName = obj.getString("fName");
                        String lName = obj.getString("lName");
                        String email = obj.getString("email");
                        String username = obj.getString("username");
                        String password = obj.getString("password");
                        String sBirthdate = obj.getString("birthday");
                        Date birthdate = stringToDate(sBirthdate);

                        users.add(new UserDTO(fName, lName, email, username, password, (java.sql.Date) birthdate));
                    });
                    if (userRepository.add(users)) {

                        claim.put("type", type);

                        for (UserDTO user : users) {
                            JsonObjectBuilder b = Json.createObjectBuilder();
                            b.add("fName", user.getFirstName());
                            b.add("lName", user.getLastName());
                            b.add("email", user.getEmail());
                            b.add("username", user.getUsername());
                            b.add("password", user.getPassword());
                            b.add("birthday", user.getBirthdate().toString());
                        }

                        claim.put("content", users);
                    } else {
                        claim.put("type", PacketType.Error);
                        claim.put("error", ErrorType.userExists);
                        claim.put("errorMessage", "Bruger eksistere allerede");
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                break;
            case UpdateUser:
                UserRepository userRepository = new UserRepository();
                JsonArray value = content.getJsonArray("users");
                List<UserDTO> users = new Vector<>();

                break;
            default:
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
