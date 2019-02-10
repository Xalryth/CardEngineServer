package Repositories.Specifications.User;

import DTOs.UserDTO;
import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAddSpecification implements SqlStatementSpecification {
    UserDTO entity;

    public UserAddSpecification(UserDTO entity)
    {
        this.entity = entity;
    }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO [User] (FirstName, LastName, Email, Username, Password, Salt, Birthday) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getUsername());
            statement.setString(5, entity.getPassword());
            statement.setBytes(6, entity.getSalt());
            statement.setDate(7, entity.getBirthdate());
            return statement;
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
    }
}
