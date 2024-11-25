package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("LAMB")
public class Lamb extends Sheep {


    public Lamb(Gender gender) {
        super(gender); // Set gender based on client input
    }


}
