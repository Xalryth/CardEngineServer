package Repositories.Specifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RulesetsByGameModeSpecification implements SqlStatementSpecification {
    String name;
    public RulesetsByGameModeSpecification(String name){this.name = name;};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM GameMode\n" +
                    "INNER JOIN RuleSet ON Ruleset.GameModeId = GameMode.GameModeId\n" +
                    "WHERE Gamemode.name = ?;");
            statement.setString(1, name);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
