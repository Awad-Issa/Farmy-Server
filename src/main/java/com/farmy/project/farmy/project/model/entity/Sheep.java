package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private int age;  // Age in months

    @Column(name = "gender", nullable = false)
    protected Gender gender;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Column(name = "weight")
    private double weight;

//    @OneToMany(mappedBy = "mother", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Sheep> offspring;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Sheep mother;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Sheep father;

    protected Sheep(Gender gender) {
        this.gender = gender;
    }
}
