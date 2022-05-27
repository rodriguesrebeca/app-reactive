package com.exercises.appreactive.document;

import com.exercises.appreactive.dto.PatientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    private String id = UUID.randomUUID().toString();
    private String patientName;
    private String dateBirth;
    private String email;
    private String phoneNumber;
    private Doctor doctor;

    public Patient(PatientRequest patientRequest) {
        patientName = patientRequest.getPatientName();
        dateBirth = patientRequest.getDateBirth();
        email = patientRequest.getEmail();
        phoneNumber = patientRequest.getPhoneNumber();
        doctor = patientRequest.getDoctor();
    }
}
