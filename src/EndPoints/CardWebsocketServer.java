/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */

package EndPoints;

import Handlers.DataHandler;
import Handlers.MessageHandler;
import Logging.LogType;
/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
import Logging.Loggable;

import java.net.URI;
import java.util.Map;

public class CardWebsocketServer extends ServerEndPoint implements Loggable,WebsocketEndPoint, MessageHandler, DataHandler {
    public CardWebsocketServer(URI URI) {
        super(URI);
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

    //JsonObject er en del af glassfish og der vil derfor komme en fejl
    //så længe at glassfish ikke er instaleret på computeren
    //@Override
    //public void sendMessage(JsonObject jsonObject) {

    //}

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
