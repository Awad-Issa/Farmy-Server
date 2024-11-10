package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DiscriminatorValue("EWE")
@Entity
public class Ewe extends Sheep{

    public Ewe() {
        super(Gender.FEMALE); // Set gender to FEMALE
    }

}
