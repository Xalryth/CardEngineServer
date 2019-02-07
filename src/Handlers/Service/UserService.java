/**
 * @author Christoffer Pietras
 * @version 1
 * @since 07-02-2019
 */

package Handlers.Service;

import EndPoints.PacketType;
import javax.json.JsonArray;
import java.util.Map;

interface UserService{
    Map createUsers(JsonArray jsonArray, PacketType packetType);
    Map updateUsers(JsonArray jsonArray, PacketType packetType);
    Map RemoveUsers(JsonArray jsonArray, PacketType packetType);
    Map ResetPasswordUsers(JsonArray jsonArray, PacketType packetType);
    Map login(JsonArray jsonArray, PacketType packetType);
}
