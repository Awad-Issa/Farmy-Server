package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("LAMB")
public class Lamb extends Sheep{


    public Lamb(Gender gender) {
        super(gender); // Set gender based on client input
    }


}
