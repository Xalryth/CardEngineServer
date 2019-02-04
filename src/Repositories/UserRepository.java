package Repositories;

import DTOs.UserDTO;
import Repositories.Specifications.Specification;
import Repositories.Specifications.UserAddSpecification;

import java.util.Collection;

public class UserRepository implements Repository<UserDTO> {

    @Override
    public Collection<UserDTO> getAll() {
        return null;
    }

    @Override
    public void add(UserDTO entity) {
        UserAddSpecification a = new UserAddSpecification(entity.firstname);
        a.ToSqlPreparedStatement(con);
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
