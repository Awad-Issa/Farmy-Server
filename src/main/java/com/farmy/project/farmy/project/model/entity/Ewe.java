package com.farmy.project.farmy.project.model.entity;

import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import com.farmy.project.farmy.project.model.entity.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Ewe extends Sheep {

    @OneToMany(mappedBy = "mother")
    private List<Sheep> children = new ArrayList<>();

    @Column(name = "pregnancy_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PregnancyStatus pregnancyStatus;

    @OneToMany(mappedBy = "ewe", cascade = CascadeType.ALL)
    private List<Pregnancy> pregnancies;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sponge> sponges;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Hormone> hormones;


    @OneToMany(mappedBy = "ewe", cascade = CascadeType.ALL)
    private List<Insemination> insemination;

    public Ewe() {
        setGender(Gender.FEMALE);
        this.setType(Type.EWE);
    }

    public void addChild(Sheep child) {
        child.setMother(this);
        this.children.add(child);
    }

    public void addSponge(Sponge sponge){
        sponge.setEwe(this);
        this.sponges.add(sponge);
    }

    public void addHormone(Hormone hormone){
        hormone.setEwe(this);
        this.hormones.add(hormone);
    }
    public void addInsemination(Insemination insemination){
        insemination.setEwe(this);
        this.insemination.add(insemination);
    }


}
