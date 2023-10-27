package com.ca.businesslayer.clientservice;

import com.ca.selfscheduling.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AppointmentClientService {

    @GrpcClient("grpc-ca-service")
    AppointmentServiceGrpc.AppointmentServiceBlockingStub synchronousClient;

    public AppointmentDetail getAppointmentBDetail(Long appointmentId){
        AppointmentDetailRequest appointmentsRequest=AppointmentDetailRequest.newBuilder().setAppointmentId(appointmentId).build();
        return synchronousClient.getAppointmentDetail(appointmentsRequest);
    }

    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest){
        return synchronousClient.createAppointment(appointmentRequest);
    }
}
