package com.exercises.appreactive.controller.router;

import com.exercises.appreactive.controller.handler.PatientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PatientRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(PatientHandler patientHandler){
        return route()
                .path("/v1/hospital", b1 -> b1
                        .nest(accept(APPLICATION_JSON), b2 -> b2
                                .POST("", patientHandler::createPatient)
                                .GET("", patientHandler::getAllPatients)
                                .GET("/{id}", patientHandler::getPatientById)
                                .DELETE("/{id}", patientHandler::deletePatientById)
                                .DELETE("", patientHandler::deleteAllPatients)))
                .build();
    }
}
