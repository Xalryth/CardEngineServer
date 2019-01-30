/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */

package EndPoints;

import Handlers.DataHandler;
import Handlers.MessageHandler;
import Logging.LogType;
import Logging.Loggable;

import javax.json.JsonObject;
import java.net.URI;
import java.util.Map;

public class CardWebsocketServer extends ServerEndPoint implements Loggable,WebsocketEndPoint, MessageHandler, DataHandler {
    public CardWebsocketServer(URI uri) {
        super(uri);
    }

    @Override
    public void log() {

    }

    @Override
    public void log(LogType logType) {

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
}
