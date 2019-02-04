import DTOs.UserDTO;
import Repositories.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {
        UserRepository a = new UserRepository();
        try {
            var test = new UserDTO("fName", "lName", "email", "username", "password", Date.valueOf(LocalDate.of(1967, 6, 22)));
            a.add(test);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}