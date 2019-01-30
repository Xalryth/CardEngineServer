/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package Handlers;

import java.util.Map;

public interface DataHandler<T> {
    T decodeMessage(String message);
    T encodeMessage(Map<String,Object> message);
}
