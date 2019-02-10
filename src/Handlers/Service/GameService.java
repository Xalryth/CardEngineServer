/**
 * @author Christoffer Pietras
 * @version 1
 * @since 07-02-2019
 */

package Handlers.Service;

import EndPoints.PacketType;
import Users.User;

import javax.json.JsonArray;
import javax.websocket.Session;
import java.util.Map;

interface GameService {
    Map createLobby(JsonArray jsonArray, PacketType packetType);
}
