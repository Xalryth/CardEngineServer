package DTOs;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Random;
import java.util.regex.Pattern;

/*
* @Author Peter C. Straarup 4/2-2019
* User data object for holding data from user requests,
* as well as returning data to the user.
* Also serves to hold data regarding password.
* */

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

    //for user signing requests
    public UserDTO(String username, String password){
        this.username = username;
        this.password = password;
    }

    //returned object from database when doing user lookups and password checks
    public UserDTO(int id, String username, String hashedPassword, byte[] salt){
        this.id = id;
        this.username = username;
        this.password = hashedPassword;
        this.salt = salt;
    }

    //for user requests, signing up etc.
    public UserDTO(String fName, String lName, String email, String username, String password, Date birthdate) {
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.username = username;
        setPassword(password);
        this.birthdate = birthdate;
    }

    //full user object without password details
    public UserDTO(int id, String fName, String lName, String email, String username, Date birthdate, Date created){
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.username = username;
        this.birthdate = birthdate;
        this.created = created;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreated() {
        return created;
    }

    //Hashes the user password with the salt
    public void hashPassword() throws NoSuchAlgorithmException{
        try {
            byte[] newSalt = (salt == null) ? new byte[128] : salt;

            if(salt == null){
                new Random().nextBytes(newSalt);
            }

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(newSalt);
            byte[] passwordBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();

            for(int i=0; i< passwordBytes.length ;i++){
                sb.append(Integer.toString((passwordBytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            this.password = sb.toString();
            setSalt(newSalt);
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
