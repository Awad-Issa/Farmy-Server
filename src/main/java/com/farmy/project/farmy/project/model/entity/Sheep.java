package com.farmy.project.farmy.project.model.entity;

import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.entity.enums.Status;
import com.farmy.project.farmy.project.model.entity.enums.Type;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


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

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "mother_id", referencedColumnName = "id")
    private Ewe mother;


}
