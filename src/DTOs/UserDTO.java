package DTOs;

import java.util.Date;

public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private byte[] salt;
    private Date birthdate;
    private Date created;

    public UserDTO(String username, String password){
        this.username = username;
        this.password = password;
    }

    public UserDTO(int id, String username, String hashedPassword, byte[] salt){
        this.username = username;
        this.password = hashedPassword;
    }
}
