package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Period;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "sheep")
public class Sheep extends BaseEntity {

    @Column(name = "num", nullable = false, unique = true)
    private Long num;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "type", nullable = false )
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "status", nullable = false )
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Ewe mother;



}
