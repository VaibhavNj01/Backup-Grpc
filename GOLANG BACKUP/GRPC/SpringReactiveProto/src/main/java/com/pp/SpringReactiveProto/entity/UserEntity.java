package com.pp.SpringReactiveProto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("user")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private String email;
}
