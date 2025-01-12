package com.farmy.project.farmy.project.model.entity;

import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.entity.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Ram extends Sheep {

    public Ram() {
        this.setGender(Gender.MALE);
        this.setType(Type.RAM);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "ram", cascade = CascadeType.ALL)
    private List<Insemination> insemination;

    public void addInsemination(Insemination insemination){
        insemination.setRam(this);
        this.insemination.add(insemination);
    }



}
