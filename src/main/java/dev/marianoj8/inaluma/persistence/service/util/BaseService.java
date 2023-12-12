package dev.marianoj8.inaluma.persistence.service.util;

import java.util.List;

public interface BaseService<T, D> {
   T getById(Long id);

    List<T> fetch();

    T create(D d);

    T update(D d);

    void delete(Long id);
}
