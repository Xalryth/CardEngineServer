package Repositories.Specifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbandonedGameEntryByUsernameSpecification implements SqlStatementSpecification {
    String username;

    public AbandonedGameEntryByUsernameSpecification(String username){this.username = username;};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT U.UserId, COUNT(*) as gamesLeaved FROM [User] as U\n" +
                    "INNER JOIN AbandonedGameEntry A ON A.UserId = U.UserId\n" +
                    "WHERE U.Username = ''\n" +
                    "GROUP BY U.UserId;");
            statement.setString(1, username);
            return statement;
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
    }
}
