package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.time.Period;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sheep_type")
@Table(name = "sheep")
public class Sheep extends BaseEntity {

    @Column(name = "num", nullable = false, unique = true)
    private long num;

    @Column(name = "age")
    private String age;

    @Column(name = "gender", nullable = false)
    protected Gender gender;

    @Column(name = "status", nullable = false )
    protected Status status;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "weight")
    private double weight;



    protected Sheep(Gender gender) {
        this.gender = gender;
    }

    protected Sheep(Status status){
        this.status = status;
    }


    @PrePersist
    @PreUpdate
    private void calculateExactAge() {
        if (birthDate != null) {
            Period period = Period.between(birthDate, LocalDate.now());
            // Format the age as a string
            this.age = period.getYears() + " years, " + period.getMonths() + " months, and " + period.getDays() + " days";
        }
    }

}
