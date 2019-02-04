package Repositories.Specifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UserByIdSpecification implements SqlSpecification, SqlStatementSpecification {
    int id;

    public UserByIdSpecification(int id){ this.id = id; }

    @Override
    public String toSqlQuery() {

    }

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        return null;
    }
}
