package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Ewe extends Sheep {


    @OneToMany(mappedBy = "mother")
    private List<Sheep> children = new ArrayList<>(); // List of Sheep (Lamb, Ewe, Ram)

    public Ewe() {
        setGender(Gender.FEMALE); // Set gender to FEMALE
        this.setType(Type.EWE);
    }


    public void addChild(Sheep child) {
        child.setMother(this);
        this.children.add(child);
    }


}
