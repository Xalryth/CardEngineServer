package Handlers.Service;

import EndPoints.PacketType;
import javax.json.JsonArray;
import java.util.Map;

interface UserService{
    Map createUser(JsonArray jsonArray, PacketType packetType);
    Map updateUser(JsonArray jsonArray, PacketType packetType);
}
