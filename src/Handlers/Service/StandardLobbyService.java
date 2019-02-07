/**
 * @author Christoffer Pietras
 * @version 1
 * @since 07-02-2019
 */

package Handlers.Service;

import DTOs.UserDTO;
import EndPoints.ErrorType;
import EndPoints.PacketType;
import Repositories.UserRepository;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class StandardLobbyService implements LobbyService {

   /* @Override
    public Map createUsers(JsonArray jsonArray, PacketType packetType) {
        Map claim = new HashMap();
        UserRepository userRepository = new UserRepository();
        List<UserDTO> users = jsonObjectToUserDTO(jsonArray);
        List<JsonObjectBuilder> createdUser = new Vector<>();

        if (userRepository.add(users)) {
            claim.put("type", packetType);
            for (UserDTO user : users) {
                JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                jsonBuilder.add("fName", user.getFirstName());
                jsonBuilder.add("lName", user.getLastName());
                jsonBuilder.add("email", user.getEmail());
                jsonBuilder.add("username", user.getUsername());
                jsonBuilder.add("password", user.getPassword());
                jsonBuilder.add("birthday", user.getBirthdate().toString());
                createdUser.add(jsonBuilder);
            }

            claim.put("content", createdUser);
        } else {
            claim.put("type", PacketType.Error);
            claim.put("error", ErrorType.userExists);
            claim.put("errorMessage", "User already exists");
        }
        return claim;
    }*/

    private List<UserDTO> jsonObjectToCreateLobby(JsonArray jsonArray){
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
