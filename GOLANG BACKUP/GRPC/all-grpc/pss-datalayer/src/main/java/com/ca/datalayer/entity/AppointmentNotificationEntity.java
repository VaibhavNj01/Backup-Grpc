package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="appointment_notification")
@EqualsAndHashCode(callSuper = true)
public class AppointmentNotificationEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "appointment_notification_appointment_notification_id_seq", sequenceName = "appointment_notification_appointment_notification_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_notification_appointment_notification_id_seq")
    @Column(name = "appointment_notification_id")
    private Long appointmentNotificationId;

    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "notification_type_id")
    private Integer notificationTypeId;

    @Column(name = "notificationstatus")
    private String notificationStatus;

}
