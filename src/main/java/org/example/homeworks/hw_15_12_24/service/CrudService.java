package org.example.homeworks.hw_15_12_24.service;

import java.util.List;

public interface CrudService<T> {
    void add(T t);

    void update(T t);

    void deleteById(int id);

    List<T> getAll();

    T getById(int id);
}