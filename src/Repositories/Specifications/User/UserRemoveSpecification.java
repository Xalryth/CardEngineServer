package Repositories.Specifications.User;

import DTOs.UserDTO;
import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRemoveSpecification implements SqlStatementSpecification {
    int userId;
    public UserRemoveSpecification(UserDTO entity)
    {
    this.userId = entity.getId(); };

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM [User] WHERE UserId = ?");
            statement.setInt(1, userId);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
