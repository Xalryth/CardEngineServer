package Repositories.Specifications;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersByMinGamesWonSpecification implements SqlStatementSpecification {
    int gamesMinWon;

    public UsersByMinGamesWonSpecification(int gamesMinWon){ this.gamesMinWon = gamesMinWon; }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT U.UserId, COUNT(*) as gamesWon FROM [User] as U\n" +
                    "INNER JOIN Score S on S.UserId = U.UserId\n" +
                    "WHERE S.Win = 1\n" +
                    "GROUP BY U.UserId\n" +
                    "having COUNT(*) > ?\n" +
                    "ORDER BY gamesWon;");

            statement.setInt(1, gamesMinWon);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
