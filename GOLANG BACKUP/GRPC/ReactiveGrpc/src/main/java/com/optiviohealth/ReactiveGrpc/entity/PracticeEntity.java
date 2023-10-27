package com.optiviohealth.ReactiveGrpc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "practice_info")
public class PracticeEntity {
    @Id
    private Long id;
    private String practiceName;
    private String address;
    private String phoneNumber;
    private String email;
}
