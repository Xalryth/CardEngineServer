import DTOs.UserDTO;
import Repositories.UserRepository;

import java.sql.Date;

public class Main {


    public static void main(String[] args) {
        UserRepository a = new UserRepository();

        /*
              this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;

         */

        var test = new UserDTO("Test1", "Test2", "Test3", "Test4", "Test5", new Date(), new Date());
        a.add();
    }

}