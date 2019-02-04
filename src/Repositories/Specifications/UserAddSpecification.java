package Repositories.Specifications;

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
    String salt;
    Date birthDay;

    public UserAddSpecification(String firstName, String lastName, String email, String userName, String password, String salt, Date birthDay)
    {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.userName = userName;
    this.password = password;
    this.salt = salt;
    this.birthDay = birthDay;};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO [User] (UserId, FirstName, LastName, Email, Username, Password, Salt, Birthday) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, userName);
            statement.setString(5, password);
            statement.setString(6, salt);
            statement.setDate(7, birthDay);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
