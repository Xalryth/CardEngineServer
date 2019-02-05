package Repositories.Specifications.User;

import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserByIdSpecification implements SqlStatementSpecification {
    int id;

    public UserByIdSpecification(int id){ this.id = id; }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM User WHERE UserId = ?");
            statement.setInt(1, id);
            return statement;
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
    }
}
