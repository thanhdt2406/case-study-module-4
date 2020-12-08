package com.codegym.casestudy4.service;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void delete(Long id);
}
