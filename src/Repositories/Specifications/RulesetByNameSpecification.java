package Repositories.Specifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RulesetByNameSpecification implements SqlStatementSpecification {
    String name;
    public RulesetByNameSpecification(String name){this.name = name;};

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM RuleSet\n" +
                    "WHERE RuleSet.name = ?;");
            statement.setString(1, name);
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
        return null;
    }
}
