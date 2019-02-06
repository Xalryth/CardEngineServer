/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package EndPoints;

import Handlers.MessageHandler;

import javax.json.JsonObject;

public interface WebsocketEndPoint<T> {

    void onOpen(T session);
    void onClose(T session);
    void onMessage(String message,T session);
    void sendMessage(JsonObject jsonObject);
}