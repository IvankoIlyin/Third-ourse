package com.example.lab2.service;

import com.example.lab2.model.User;
import com.example.lab2.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService implements Dao<User>{
    private final UserRepo repo;

    @Override
    public boolean existById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<User> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<User> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean save(User entity) {
        repo.save(entity);
        return true;
    }

    @Override
    public boolean delete(User entity) {
        repo.delete(entity);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        return false;
    }

    @Override
    public boolean update(User entity) {
        delete(entity.getId());
        save(entity);
        return true;
    }
}
