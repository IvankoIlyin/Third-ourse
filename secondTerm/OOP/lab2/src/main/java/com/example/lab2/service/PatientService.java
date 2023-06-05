package com.example.lab2.service;

import com.example.lab2.model.Patient;
import com.example.lab2.model.User;
import com.example.lab2.repo.PatientRepo;
import com.example.lab2.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PatientService implements Dao<Patient> {
    private final PatientRepo repo;

    @Override
    public boolean existById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Patient> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean save(Patient entity) {
        repo.save(entity);
        return true;
    }

    @Override
    public boolean delete(Patient entity) {
        repo.delete(entity);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        repo.deleteById(id);
        return false;
    }
}
