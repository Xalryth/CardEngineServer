/**
 * @author Christoffer Pietras
 * @version 1
 * @since 07-02-2019
 */

package Handlers.Service;

import DTOs.UserDTO;
import EndPoints.PacketType;
import Rooms.Lobbies.Lobby;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

    /*
    Christoffer Pietras
    Game handler should call around in difrence class to handle the flow of the game
    */

public class StandardGameService implements GameService {
    private static Set<Lobby> lobbies;

    @Override
    public Map createLobby(JsonArray jsonArray, PacketType packetType) {
        return null;
    }

    private List<UserDTO> jsonObjectToUserDTO(JsonArray jsonArray){
        List<UserDTO> users = new Vector<>();

        jsonArray.forEach(item -> {
            JsonObject obj = (JsonObject) item;
            String fName = obj.getString("fName");
            String lName = obj.getString("lName");
            String email = obj.getString("email");
            String username = obj.getString("username");
            String password = obj.getString("password");
            String sBirthdate = obj.getString("birthday");
            Date birthdate = stringToDate(sBirthdate);

            users.add(new UserDTO(fName, lName, email, username, password, birthdate));
        });
        return users;
    }

    private Date stringToDate(String sDate) {
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date = sdf1.parse(sDate);
            Date sqlStartDate = new Date(date.getTime());
            return sqlStartDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
