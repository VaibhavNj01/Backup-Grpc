package com.optiviohealth.ReactiveGrpc.service;

import com.optiviohealth.ReactiveGrpc.entity.PatientEntity;
import com.optiviohealth.ReactiveGrpc.mapper.PatientMapper;
import com.optiviohealth.ReactiveGrpc.model.Patient;
import com.optiviohealth.ReactiveGrpc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;
@Autowired
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    public Mono<Patient> createPatient(Patient patient) {
        PatientEntity patientEntity = patientMapper.mapToEntity(patient);
        return patientRepository.save(patientEntity)
                .map(patientMapper::mapToModel);
    }

    public Mono<Patient> getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(patientMapper::mapToModel);
    }

    public Flux<Patient> getAllPatients() {
        return patientRepository.findAll()
                .map(patientMapper::mapToModel);
    }

//    public Mono<Patient> updatePatient(Long id, Patient patient) {
//        return patientRepository.findById(id)
//                .flatMap(existingPatient -> {
//                    PatientEntity updatedPatient = patientMapper.mapToEntity(patient);
//                    existingPatient.setFirstName(updatedPatient.getFirstName());
//                    existingPatient.setLastName(updatedPatient.getLastName());
//                    existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
//                    existingPatient.setGender(updatedPatient.getGender());
//                    existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
//                    existingPatient.setEmail(updatedPatient.getEmail());
//                    return patientRepository.save(existingPatient);
//                })
//                .map(patientMapper::mapToModel);
//    }

    public Mono<Void> deletePatient(Long id) {
        return patientRepository.deleteById(id);
    }
}
