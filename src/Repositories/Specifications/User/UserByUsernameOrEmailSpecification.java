package Repositories.Specifications.User;

import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserByUsernameOrEmailSpecification implements SqlStatementSpecification {
    String username;
    String email;

    public UserByUsernameOrEmailSpecification(String username, String email){ this.username = username; this.email = email; }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM [User] WHERE Username = ? OR Email = ?; ");
            statement.setString(1, username);
            statement.setString(2, email);
            return statement;
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
    }
}
