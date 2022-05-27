package com.exercises.appreactive.dto;

import com.exercises.appreactive.document.Doctor;
import com.exercises.appreactive.document.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {

    private String id;
    private String patientName;
    private String dateBirth;
    private String email;
    private String phoneNumber;
    private Doctor doctor;

    public static PatientResponse toResponse(Patient patient){
        return PatientResponse.builder()
                .id(patient.getId())
                .patientName(patient.getPatientName())
                .dateBirth(patient.getDateBirth())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .doctor(patient.getDoctor())
                .build();
    }
}
