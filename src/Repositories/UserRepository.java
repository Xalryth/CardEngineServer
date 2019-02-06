package Repositories;

import DTOs.UserDTO;
import Repositories.Specifications.Specification;
import Repositories.Specifications.User.UserAddSpecification;
import Repositories.Specifications.User.UserAllSpecification;
import Repositories.Specifications.User.UserRemoveSpecification;
import Repositories.Specifications.User.UserUpdateSpecification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class UserRepository implements Repository<UserDTO> {

    @Override
    public Collection<UserDTO> getAll() {
        Connection conn = null;
        Collection<UserDTO> colUserDTO = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://10.108.146.2;user=Whist;" +
                    "password=Whist123;databaseName=CardGameEngine_DB");
            UserAllSpecification userAllSpec = new UserAllSpecification();
            ResultSet rs = userAllSpec.ToSqlPreparedStatement(conn).executeQuery();

            while (rs.next()){
                colUserDTO.add(new UserDTO(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
                        rs.getString("username"), rs.getDate("birthday"), rs.getDate("created")));
            }

                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return colUserDTO;
    }

    @Override
    public boolean add(UserDTO entity) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://10.108.146.2;user=Whist;" +
                    "password=Whist123;databaseName=CardGameEngine_DB");
            UserAddSpecification userAddSpec = new UserAddSpecification(entity);
            userAddSpec.ToSqlPreparedStatement(conn).executeQuery();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(Collection<UserDTO> entities) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://10.108.146.2;user=Whist;" +
                    "password=Whist123;databaseName=CardGameEngine_DB");
            for (UserDTO item : entities) {
                UserAddSpecification userAddSpec = new UserAddSpecification(item);
                userAddSpec.ToSqlPreparedStatement(conn).executeQuery();
            }
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UserDTO entity) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://10.108.146.2;user=Whist;" +
                    "password=Whist123;databaseName=CardGameEngine_DB");
            UserUpdateSpecification userUpdateSpec = new UserUpdateSpecification(entity);
            userUpdateSpec.ToSqlPreparedStatement(conn).executeQuery() ;
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(UserDTO entity) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://10.108.146.2;user=Whist;" +
                    "password=Whist123;databaseName=CardGameEngine_DB");
            UserRemoveSpecification userRemoveSpec = new UserRemoveSpecification(entity);
            userRemoveSpec.ToSqlPreparedStatement(conn).executeQuery() ;
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public Collection<UserDTO> query(Specification specification) {
        return null;
    }
}
