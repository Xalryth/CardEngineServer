package Repositories;

import DTOs.UserDTO;
import Repositories.Specifications.Specification;

import java.util.Collection;

/*
   Christoffer Pietras
   Game Repository difrence methodes to call specification there create, update, delete or return a list of objects from DB
 */


public class GameRepository implements Repository<UserDTO> {

    @Override
    public Collection<UserDTO> getAll() {
        return null;
    }

    @Override
    public boolean add(UserDTO entity) {
        return false;
    }

    @Override
    public boolean add(Collection<UserDTO> entities) {
        return false;
    }

    @Override
    public boolean update(UserDTO entity) {
        return false;
    }

    @Override
    public boolean remove(UserDTO entity) {
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
