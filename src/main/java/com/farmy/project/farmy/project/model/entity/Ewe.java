package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


@Data
@DiscriminatorValue("EWE")
@Entity
public class Ewe extends Sheep {

    public Ewe() {
        super(Gender.FEMALE); // Set gender to FEMALE
    }

//    @Column(name = "pregnancy", nullable = false)
//    private Pregnancy PregnancyStatus;


//    @OneToMany(mappedBy = "mother")
//    private List<Sheep> sons;


}
