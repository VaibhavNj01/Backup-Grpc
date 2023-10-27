package com.optiviohealth.ReactiveGrpc.controller;

import com.optiviohealth.ReactiveGrpc.model.Appointment;
import com.optiviohealth.ReactiveGrpc.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Mono<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Mono<Appointment> getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping
    public Flux<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

//    @PutMapping("/{id}")
//    public Mono<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
//        return appointmentService.updateAppointment(id, appointment);
//    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAppointment(@PathVariable Long id) {
        return appointmentService.deleteAppointment(id);
    }
}
