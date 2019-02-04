package Repositories.Specifications;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface SqlStatementSpecification extends Specification {
    PreparedStatement ToSqlPreparedStatement(Connection con);
}
