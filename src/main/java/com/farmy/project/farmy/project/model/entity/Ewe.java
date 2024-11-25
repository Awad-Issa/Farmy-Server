package com.farmy.project.farmy.project.model.entity;

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

    @OneToMany(mappedBy = "mother")
    private List<Sheep> sons;


}
