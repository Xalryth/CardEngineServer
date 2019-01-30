/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package EndPoints;

import Handlers.MessageHandler;

public interface WebsocketEndPoint<T> {
    void onOpen(T session);
    void onClose(T session);
    void onMessage(String message,T session);
    //JsonObject er en del af glassfish og der vil derfor komme en fejl
    //så længe at glassfish ikke er instaleret på computeren
    //void sendMessage(JsonObject jsonObject);
    void addMessageHandler(MessageHandler handler);
}