package Repositories.Specifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GamesByNewestSpecification implements SqlStatementSpecification {
    int amount;

    public GamesByNewestSpecification(){ this.amount = 10; }
    public GamesByNewestSpecification(int amount){ this.amount = amount; }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Game\n" +
                    "WHERE Game.Created >= DATEADD(day, -?, getdate());");

            statement.setInt(1, amount);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
