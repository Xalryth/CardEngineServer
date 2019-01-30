package Repositories.Specifications;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class UserByIdSpecification implements SqlSpecification {
    int id;

    public UserByIdSpecification(int id){ this.id = id; }

    @Override
    public String toSqlQuery() {

    }
}
