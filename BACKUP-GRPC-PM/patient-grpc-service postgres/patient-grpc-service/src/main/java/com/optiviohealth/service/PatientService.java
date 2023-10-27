    package com.optiviohealth.service;


    import com.optiviohealth.PatientEntity;
    import com.optiviohealth.PatientResponse;
    import com.optiviohealth.ReactorPatientServiceGrpc;
    import com.optiviohealth.mapper.PatientMapper;
    import com.optiviohealth.repository.PatientRepository;
    import lombok.extern.log4j.Log4j2;
    import net.devh.boot.grpc.server.service.GrpcService;
    import reactor.core.publisher.Mono;

    @GrpcService
    @Log4j2
    public class PatientService extends ReactorPatientServiceGrpc.PatientServiceImplBase {
        private final PatientRepository patientRepository;

        private final PatientMapper patientMapper;
        public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
            this.patientRepository = patientRepository;
            this.patientMapper = patientMapper;
        }

        @Override
        public Mono<PatientResponse> createPatient(PatientEntity request) {
            com.optiviohealth.model.PatientEntity patientEntity = patientMapper.ProtoToModel(request);
            patientRepository.save(patientEntity);
            PatientResponse patientResponse = patientMapper.mapEntityToModelPostResponse(patientEntity);
            return Mono.just(patientResponse);
        }


    }
