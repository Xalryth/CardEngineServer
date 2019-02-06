package Repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getAll();
    boolean add(T entity);
    boolean add(Collection<T> entities);
    boolean update(T entity);
    boolean remove(T entity);
    void remove(Repositories.Specifications.Specification specification);
    Collection<T> query(Repositories.Specifications.Specification specification);
}
