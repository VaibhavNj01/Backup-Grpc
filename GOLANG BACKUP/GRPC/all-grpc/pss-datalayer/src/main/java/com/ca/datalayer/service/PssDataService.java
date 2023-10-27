package com.ca.datalayer.service;

import com.ca.datalayer.entity.*;
import com.ca.datalayer.mapper.SelfSchedulingMapper;
import com.ca.datalayer.repository.*;

import com.ca.selfscheduling.*;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@GrpcService
public class PssDataService extends AppointmentServiceGrpc.AppointmentServiceImplBase {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentTypeRepository appointmentTypeRepository;
    private final PracticeRepository practiceRepository;
    private final ProviderRepository providerRepository;
    private final LocationRepository locationRepository;
    private final SourceTypeRepository sourceTypeRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMethodRepository appointmentMethodRepository;

    @Autowired
    public PssDataService(AppointmentRepository appointmentRepository, AppointmentTypeRepository appointmentTypeRepository,
                          PracticeRepository practiceRepository,
                          ProviderRepository providerRepository, LocationRepository locationRepository,
                          SourceTypeRepository sourceTypeRepository,
                          PatientRepository patientRepository, AppointmentMethodRepository appointmentMethodRepository){
        this.appointmentRepository=appointmentRepository;
        this.appointmentTypeRepository=appointmentTypeRepository;
        this.practiceRepository=practiceRepository;
        this.providerRepository=providerRepository;
        this.locationRepository=locationRepository;
        this.sourceTypeRepository=sourceTypeRepository;
        this.patientRepository=patientRepository;
        this.appointmentMethodRepository=appointmentMethodRepository;
    }

    @Override
    public void createAppointment(AppointmentRequest request, StreamObserver<AppointmentResponse> responseObserver) {

        AppointmentEntity appointmentEntity=new AppointmentEntity();
        Optional<PracticeEntity> practiceEntity=practiceRepository.findByPracticeId(request.getAppointmentRequestParam().getPracticeId());
        if (Objects.isNull(practiceEntity)){
            throw new IllegalArgumentException("practice not found");
        }
        Optional<PatientEntity> patientEntity=patientRepository.findByPatientId(request.getAppointmentRequestParam().getMemberId());
        if (Objects.isNull(patientEntity)){
            throw new IllegalArgumentException("person not found");
        }

        Optional<AppointmentMethodEntity> appointmentMethodEntity=appointmentMethodRepository.findByName(request.getAppointmentRequestBody().getMethod());
        if(appointmentMethodEntity.isPresent()){
            appointmentEntity.setAppointmentMethod(appointmentMethodEntity.get().getId());
        }
        Optional<AppointmentTypeEntity> appointmentTypeEntity=appointmentTypeRepository.findByName(request.getAppointmentRequestBody().getAppointmentType());
        if(appointmentTypeEntity.isPresent()){
            appointmentEntity.setAppointmentType(appointmentTypeEntity.get());
        }

        Optional<SourceTypeEntity> sourceTypeEntity=sourceTypeRepository.findByName(request.getAppointmentRequestBody().getSourceOfBooking());
        if(sourceTypeEntity.isPresent()){
            appointmentEntity.setSourceType(sourceTypeEntity.get());
        }

        Optional<ProviderEntity> providerEntity=providerRepository.findByProviderId(request.getAppointmentRequestBody().getProviderId());
        if(providerEntity.isPresent()){
            appointmentEntity.setProvider(providerEntity.get());
        }
        Optional<LocationEntity> locationEntity=locationRepository.findByLocationId(request.getAppointmentRequestBody().getLocationId());
        if(locationEntity.isPresent()){
            appointmentEntity.setLocation(locationEntity.get());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(request.getAppointmentRequestBody().getDatetime(), formatter);

        appointmentEntity.setStart(dateTime);
        appointmentEntity.setNote(request.getAppointmentRequestBody().getNote());
        appointmentEntity.setPractice(practiceEntity.get());
        appointmentEntity.setPatient(patientEntity.get());
        appointmentEntity.setCreatedBy(1L);
        AppointmentEntity appointmentEntity1=appointmentRepository.save(appointmentEntity);


        if(Objects.nonNull(appointmentEntity1)){
            AppointmentResponse appointmentResponse=AppointmentResponse.newBuilder().setAppointmentId(appointmentEntity1.getAppointmentId()).build();
            responseObserver.onNext(appointmentResponse);
            responseObserver.onCompleted();
        }else{
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }

        //super.createAppointment(request, responseObserver);

    }

    @Override
    public void getAppointmentDetail(AppointmentDetailRequest request, StreamObserver<AppointmentDetail> responseObserver) {
        Optional<AppointmentEntity> appointmentEntity=appointmentRepository.findByAppointmentId(request.getAppointmentId());
        if(appointmentEntity.isPresent()){
            AppointmentDetail appointmentDetails= SelfSchedulingMapper.MAPPER.mapAppointmentDetail(appointmentEntity.get());
            responseObserver.onNext(appointmentDetails);
            responseObserver.onCompleted();
        }else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }
}
