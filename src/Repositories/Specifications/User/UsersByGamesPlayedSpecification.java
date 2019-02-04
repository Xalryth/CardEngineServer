package Repositories.Specifications.User;

import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersByGamesPlayedSpecification implements SqlStatementSpecification {

    public UsersByGamesPlayedSpecification(){};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT U.UserId, count(*) as gamesPlayed FROM [User] as U\n" +
                    "INNER JOIN Score S on S.UserId = U.UserId\n" +
                    "GROUP BY U.UserId\n" +
                    "ORDER BY gamesPlayed;");
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
