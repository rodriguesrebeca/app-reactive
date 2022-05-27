package com.exercises.appreactive.dto;

import com.exercises.appreactive.document.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequest {

    private String patientName;
    private String dateBirth;
    private String email;
    private String phoneNumber;
    private Doctor doctor;

}
