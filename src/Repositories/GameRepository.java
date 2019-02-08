package Repositories;

import DTOs.GameDTO;
import Repositories.Specifications.Specification;

import java.util.Collection;

public class GameRepository implements Repository<GameDTO> {
    @Override
    public Collection<GameDTO> getAll() {
        return null;
    }

    @Override
    public boolean add(GameDTO entity) {
        return false;
    }

    @Override
    public boolean add(Collection<GameDTO> entities) {
        return false;
    }

    @Override
    public boolean update(GameDTO entity) {
        return false;
    }

    @Override
    public boolean remove(GameDTO entity) {
        return false;
    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public Collection<GameDTO> query(Specification specification) {
        return null;
    }
}
