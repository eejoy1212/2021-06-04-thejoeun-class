package com.example.class0604.DTO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Member {
    @Id
    String id;
    @Column
    String name;
    @Column
    String phone;
}
