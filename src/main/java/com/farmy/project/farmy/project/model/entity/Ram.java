package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Formula;

@Data
@Entity
@DiscriminatorValue("RAM")
public class Ram extends Sheep {

    public Ram() {
        super(Gender.MALE);
    }
    



}
