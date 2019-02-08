/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package Handlers;

import javax.json.JsonObject;
import javax.websocket.Session;

public interface MessageHandler {
    JsonObject handleMessage(String message, Session session);
}
