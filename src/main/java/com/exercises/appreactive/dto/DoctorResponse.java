package com.exercises.appreactive.dto;

import com.exercises.appreactive.document.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {

    private String id;
    private String doctorName;
    private String specialties;
    private Patient patient;
}
