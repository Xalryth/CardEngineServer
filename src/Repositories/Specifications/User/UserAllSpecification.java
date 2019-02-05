package Repositories.Specifications.User;

import DTOs.UserDTO;
import Repositories.Specifications.SqlStatementSpecification;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAllSpecification implements SqlStatementSpecification {

    @Override
    public PreparedStatement ToSqlPreparedStatement(Connection con) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM [User]");
            return statement;
        } catch (SQLException up){
            //throw up;
            throw new Error(up.getMessage());
        }
    }
}
