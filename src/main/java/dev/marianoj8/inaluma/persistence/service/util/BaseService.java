package dev.marianoj8.inaluma.persistence.service;

import java.util.List;

public interface BaseService<E, D> {
    E getById(Long id);

    List<E> fetch(String... all);

    E create(D d);

    E update(D d);

    void delete(Long id);
}
