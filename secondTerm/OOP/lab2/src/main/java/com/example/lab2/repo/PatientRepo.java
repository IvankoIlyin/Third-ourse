package com.example.lab2.repo;

import com.example.lab2.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient,Long> {
}
