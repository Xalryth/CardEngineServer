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
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    Christoffer Pietras
    Handle difrence user request like create, update, delete and login
 */

public class StandardUserService implements UserService {

    @Override
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
    }

    @Override
    public Map updateUsers(JsonArray jsonArray, PacketType packetType) {
        Map claim = new HashMap();
        UserRepository userRepository = new UserRepository();
        List<UserDTO> users = jsonObjectToUserDTO(jsonArray);
        List<JsonObjectBuilder> updatedUser = new Vector<>();

        for (UserDTO user : users) {
            if (userRepository.update(user)) {
                claim.put("type", packetType);
                JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                jsonBuilder.add("userId", user.getId());
                jsonBuilder.add("fName", user.getFirstName());
                jsonBuilder.add("lName", user.getLastName());
                jsonBuilder.add("email", user.getEmail());
                jsonBuilder.add("username", user.getUsername());
                jsonBuilder.add("password", user.getPassword());
                jsonBuilder.add("birthday", user.getBirthdate().toString());
                updatedUser.add(jsonBuilder);
            }
        }

        if (updatedUser.isEmpty()){
            claim.put("type", PacketType.Error);
            claim.put("error", ErrorType.userExists);
            claim.put("errorMessage", "Username already  exists");
        } else {
            claim.put("type", packetType);
            claim.put("content", updatedUser);
        }
        return claim;
    }

    @Override
    public Map RemoveUsers(JsonArray jsonArray, PacketType packetType) {
        Map claim = new HashMap();
        UserRepository userRepository = new UserRepository();
        List<UserDTO> users = jsonObjectToUserDTO(jsonArray);
        List<JsonObjectBuilder> deletedUser = new Vector<>();

        for (UserDTO user : users) {
            if (userRepository.remove(user)) {
                JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                jsonBuilder.add("userId", user.getId());
                jsonBuilder.add("fName", user.getFirstName());
                jsonBuilder.add("lName", user.getLastName());
                jsonBuilder.add("email", user.getEmail());
                jsonBuilder.add("username", user.getUsername());
                jsonBuilder.add("password", user.getPassword());
                jsonBuilder.add("birthday", user.getBirthdate().toString());
                deletedUser.add(jsonBuilder);
            }
        }
        if (deletedUser.isEmpty()){
            claim.put("type", PacketType.Error);
            claim.put("error", ErrorType.userExists);
            claim.put("errorMessage", "user does not exist");
        } else {
            claim.put("type", packetType);
            claim.put("content", deletedUser);
        }
        return claim;
    }

    @Override
    public Map ResetPasswordUsers(JsonArray jsonArray, PacketType packetType) {
        Map claim = new HashMap();
        UserRepository userRepository = new UserRepository();
        List<UserDTO> users = jsonObjectToUserDTO(jsonArray);
        List<JsonObjectBuilder> resetPasswordUser = new Vector<>();

        //TODO RESET PASSWORD
        return null;
    }

    @Override
    public Map login(JsonArray jsonArray, PacketType packetType) {
        Map claim = new HashMap();
        UserRepository userRepository = new UserRepository();
        List<UserDTO> users = jsonObjectToUserDTO(jsonArray);
        List<JsonObjectBuilder> loginUser = new Vector<>();

        UserDTO usersDB = userRepository.getUserByUsernameOrEmail(users.get(0).getUsername(), users.get(0).getEmail());

        if (usersDB != null) {
            try {
                users.get(0).hashPassword();
                if (users.get(0).getPassword() == usersDB.getPassword()) {
                    JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
                    jsonBuilder.add("userId", usersDB.getId());
                    jsonBuilder.add("fName", usersDB.getFirstName());
                    jsonBuilder.add("lName", usersDB.getLastName());
                    jsonBuilder.add("username", usersDB.getUsername());
                    jsonBuilder.add("email", usersDB.getEmail());
                    loginUser.add(jsonBuilder);
                    claim.put("type", packetType);
                    claim.put("content", loginUser);
                } else {
                    claim.put("type", PacketType.Error);
                    claim.put("error", ErrorType.userWrongPassword);
                    claim.put("errorMessage", "Wrong password");
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            claim.put("type", PacketType.Error);
            claim.put("error", ErrorType.userNotExists);
            claim.put("errorMessage", "User does not exists");
        }
        return claim;
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
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            return sqlStartDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
