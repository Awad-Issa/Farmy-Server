package com.farmy.project.farmy.project.model.entity;

import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.entity.enums.Pregnancy;
import com.farmy.project.farmy.project.model.entity.enums.Type;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Ewe extends Sheep {

    @OneToMany(mappedBy = "mother")
    @JsonManagedReference
    private List<Sheep> children = new ArrayList<>();

    public Ewe() {
        setGender(Gender.FEMALE);
        this.setType(Type.EWE);
    }

    public void addChild(Sheep child) {
        child.setMother(this);
        this.children.add(child);
    }


    @Column(name = "pregnancy_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Pregnancy pregnancyStatus;


}
