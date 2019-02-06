/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package Handlers;

import javax.json.JsonObject;

public interface MessageHandler {
    JsonObject handleMessage(String message);
}
