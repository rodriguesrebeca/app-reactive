package com.exercises.appreactive.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    private String id = UUID.randomUUID().toString();
    private String doctorName;
    private String specialties;
}
