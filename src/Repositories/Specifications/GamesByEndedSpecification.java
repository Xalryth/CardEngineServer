package Repositories.Specifications;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GamesByEndedSpecification implements SqlStatementSpecification {
    Date date;
    public GamesByEndedSpecification(Date date){this.date = date;};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Game WHERE Created = ?");
            statement.setDate(1, date);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
