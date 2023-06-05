package com.example.lab2.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Dao<E> {
    boolean existById(Long id);
    Optional<E> getById(Long id);
    List<E> getAll();
    boolean save(E entity);
    boolean delete(E entity);
    boolean delete(Long id);
}