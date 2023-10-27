package com.optiviohealth.ReactiveGrpc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Practice {
    private Long id;
    private String practiceName;
    private String address;
    private String phoneNumber;
    private String email;
}
