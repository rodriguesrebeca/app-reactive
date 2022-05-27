package com.exercises.appreactive.controller.handler;

import com.exercises.appreactive.document.Patient;
import com.exercises.appreactive.dto.PatientRequest;
import com.exercises.appreactive.dto.PatientResponse;
import com.exercises.appreactive.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PatientHandler {

    private final PatientService patientService;

    public Mono<ServerResponse> createPatient(ServerRequest request){
        Mono<PatientRequest> patientRequestMono = request.bodyToMono(PatientRequest.class);

        return ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(patientRequestMono.flatMap(patientService::createPatient), PatientResponse.class));
    }

    public Mono<ServerResponse> getAllPatients(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(patientService.getAllPatients(), Patient.class);
    }

    public Mono<ServerResponse> getPatientById(ServerRequest request){
        String id = request.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(patientService.getPatientById(id), Patient.class);
    }

    public Mono<ServerResponse> deletePatientById(ServerRequest request){
        String id = request.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(patientService.deletePatientById(id), Patient.class);
    }

    public Mono<ServerResponse> deleteAllPatients(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(patientService.deleteAllPatients(), Patient.class);
    }
}
