package com.exercises.appreactive.service;

import com.exercises.appreactive.document.Patient;
import com.exercises.appreactive.dto.PatientRequest;
import com.exercises.appreactive.dto.PatientResponse;
import com.exercises.appreactive.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Mono<PatientResponse> createPatient(PatientRequest patientRequest){
        Patient patient = new Patient(patientRequest);
        return patientRepository.save(patient).map(PatientResponse::toResponse);
    }

    public Flux<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Mono<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public Mono<Void> deletePatientById(String id){
        return patientRepository.deleteById(id);
    }

    public Mono<Void> deleteAllPatients(){
        return patientRepository.deleteAll();
    }
}
