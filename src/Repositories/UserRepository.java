package Repositories;

import DTOs.UserDTO;
import Repositories.Specifications.Specification;
import Repositories.Specifications.UserAddSpecification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class UserRepository implements Repository<UserDTO> {

    @Override
    public Collection<UserDTO> getAll() {
        return null;
    }

    @Override
    public void add(UserDTO entity) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.108.146.2;user=Whist;" +
                    "password=Whist123;databaseName=CardGameEngine_DB");
            UserAddSpecification obj = new UserAddSpecification(entity);
            obj.ToSqlPreparedStatement(conn).executeQuery() ;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Collection<UserDTO> entities) {

    }

    @Override
    public void update(UserDTO entity) {

    }

    @Override
    public void remove(UserDTO entity) {

    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public Collection<UserDTO> query(Specification specification) {
        return null;
    }
}
