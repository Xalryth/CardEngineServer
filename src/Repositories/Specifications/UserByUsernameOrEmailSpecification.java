package Repositories.Specifications;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserByUsernameOrEmailSpecification implements SqlStatementSpecification {
    String usernameOrEmail;

    public UserByUsernameOrEmailSpecification(String usernameOrEmail){ this.usernameOrEmail = usernameOrEmail; }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM [User] WHERE Username = ? OR Email = ?; ");
            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
