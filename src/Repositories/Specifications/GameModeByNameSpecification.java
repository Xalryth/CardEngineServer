package Repositories.Specifications;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameModeByNameSpecification implements SqlStatementSpecification {
    String name;
    public GameModeByNameSpecification(String name){this.name = name;};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM GameMode WHERE Name = ?");
            statement.setString(1, name);
            return statement;
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
    }
}
