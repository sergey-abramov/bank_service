package bank.service.service;

import java.util.Optional;

public interface Service<T> {

    T save(T model);

    void delete(int id);

    void update(T model);

    Iterable<T> findALL();

    Optional<T> findById(int id);
}
