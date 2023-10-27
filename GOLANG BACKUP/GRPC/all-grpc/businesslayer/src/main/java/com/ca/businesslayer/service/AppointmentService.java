package com.ca.businesslayer.service;

import com.ca.businesslayer.clientservice.AppointmentClientService;
import com.ca.selfscheduling.*;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@GrpcService
public class AppointmentService extends AppointmentServiceGrpc.AppointmentServiceImplBase {

    private final AppointmentClientService appointmentService;

    @Autowired
    public AppointmentService(AppointmentClientService appointmentService){
        this.appointmentService=appointmentService;
    }

    @Override
    public void getAppointmentDetail(AppointmentDetailRequest request, StreamObserver<AppointmentDetail> responseObserver) {
        AppointmentDetail appointmentDetails=appointmentService.getAppointmentBDetail(request.getAppointmentId());
        if(Objects.nonNull(appointmentDetails)){
            responseObserver.onNext(appointmentDetails);
            responseObserver.onCompleted();
        }else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }

    @Override
    public void createAppointment(AppointmentRequest request, StreamObserver<AppointmentResponse> responseObserver) {
        AppointmentResponse appointmentResponse=appointmentService.createAppointment(request);
        if(Objects.nonNull(appointmentResponse)){
            responseObserver.onNext(appointmentResponse);
            responseObserver.onCompleted();
        }else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }
}
