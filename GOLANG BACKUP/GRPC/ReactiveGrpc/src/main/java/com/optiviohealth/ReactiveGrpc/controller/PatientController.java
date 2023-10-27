package com.optiviohealth.ReactiveGrpc.controller;

import com.optiviohealth.ReactiveGrpc.model.Patient;
import com.optiviohealth.ReactiveGrpc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/patients")

public class PatientController {

    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Mono<Patient> createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public Mono<Patient> getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping
    public Flux<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

//    @PutMapping("/{id}")
//    public Mono<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
//        return patientService.updatePatient(id, patient);
//    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePatient(@PathVariable Long id) {
        return patientService.deletePatient(id);
    }
}
