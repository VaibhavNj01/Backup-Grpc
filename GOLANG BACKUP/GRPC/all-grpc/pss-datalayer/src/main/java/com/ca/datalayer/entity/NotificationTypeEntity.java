package com.ca.datalayer.entity;

import com.ca.datalayer.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="ex_notification_type")
@EqualsAndHashCode(callSuper = true)
public class NotificationTypeEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ex_notification_type_notification_type_id_seq", sequenceName = "ex_notification_type_notification_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex_notification_type_notification_type_id_seq")
    @Column(name = "notification_type_id")
    private Long notificationTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;
}
