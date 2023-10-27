package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="appointment")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AppointmentEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "appointment_appointment_id_seq", sequenceName = "appointment_appointment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_appointment_id_seq")
    @Column(name = "appointment_id")
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "appointment_type_id")
    private AppointmentTypeEntity appointmentType;

    @JoinColumn(name = "practice_id")
    @ManyToOne
    private PracticeEntity practice;

    @JoinColumn(name = "provider_id")
    @ManyToOne
    private ProviderEntity provider;

    @JoinColumn(name = "patient_id")
    @ManyToOne
    private PatientEntity patient;

    @JoinColumn(name = "location_id")
    @ManyToOne
    private LocationEntity location;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "duration_in_minute")
    private Integer durationInMinute;

    @Column(name = "status")
    private Integer status;

    @Column(name = "note")
    private String note;

    @Column(name = "ref_appointment_id")
    private Long refAppointmentId;

    @JoinColumn(name = "source_type")
    @ManyToOne
    private SourceTypeEntity sourceType;

    @Column(name = "appointment_method")
    private Integer appointmentMethod;
}
