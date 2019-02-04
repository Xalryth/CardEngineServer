package Repositories.Specifications.User;

import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersByGamesWonSpecification implements SqlStatementSpecification {
    public UsersByGamesWonSpecification(){};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT U.UserId, COUNT(*) as gamesWon FROM [User] as U\n" +
                    "INNER JOIN Score S on S.UserId = U.UserId\n" +
                    "WHERE S.Win = 1\n" +
                    "GROUP BY U.UserId\n" +
                    "ORDER BY gamesWon desc;");
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
