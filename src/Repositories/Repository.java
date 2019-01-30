package Repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getAll();
    void add(T entity);
    void add(Collection<T> entities);
    void update(T entity);
    void remove(T entity);
    void remove(Repositories.Specifications.Specification specification);
    Collection<T> query(Repositories.Specifications.Specification specification);
}
