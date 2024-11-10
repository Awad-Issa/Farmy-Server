package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("RAM")
public class Ram extends Sheep {

    public Ram() {
        super(Gender.MALE); // Set gender to MALE
    }


}
