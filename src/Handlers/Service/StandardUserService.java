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

public class StandardUserService implements UserService {

    @Override
    public Map createUser(JsonArray jsonArray, PacketType packetType) {
        Map claim = new HashMap();
        UserRepository userRepository = new UserRepository();
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
        if (userRepository.add(users)) {

            claim.put("type", packetType);

            for (UserDTO user : users) {
                JsonObjectBuilder b = Json.createObjectBuilder();
                b.add("fName", user.getFirstName());
                b.add("lName", user.getLastName());
                b.add("email", user.getEmail());
                b.add("username", user.getUsername());
                b.add("password", user.getPassword());
                b.add("birthday", user.getBirthdate().toString());
            }

            claim.put("content", users);
        } else {
            claim.put("type", PacketType.Error);
            claim.put("error", ErrorType.userExists);
            claim.put("errorMessage", "Bruger eksistere allerede");
        }
        return claim;
    }

    @Override
    public Map updateUser(JsonArray jsonArray, PacketType packetType) {
        return null;
    }

    private Date stringToDate(String sDate) {
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date = sdf1.parse(sDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            return sqlStartDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
