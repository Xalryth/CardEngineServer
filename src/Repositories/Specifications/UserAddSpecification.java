package Repositories.Specifications;

import DTOs.UserDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAddSpecification implements SqlStatementSpecification {
    String firstName;
    String  lastName;
    String email;
    String userName;
    String password;
    byte[] salt;
    Date birthDay;

    public UserAddSpecification(UserDTO entity)
    {
    this.firstName = entity.getFirstName();
    this.lastName = entity.getLastName();
    this.email = entity.getEmail();
    this.userName = entity.getUsername();
    this.password = entity.getPassword();
    this.salt = entity.getSalt();
    this.birthDay = entity.getBirthdate();};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO [User] (UserId, FirstName, LastName, Email, Username, Password, Salt, Birthday) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, userName);
            statement.setString(5, password);
            statement.setBytes(6, salt);
            statement.setDate(7, birthDay);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
