package repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity, int customerId);
    List<T> findAll();
}
