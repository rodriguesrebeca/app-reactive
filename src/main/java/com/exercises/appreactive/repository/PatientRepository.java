package com.exercises.appreactive.repository;

import com.exercises.appreactive.document.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, String> {
}
