package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

@Data
@Entity
public class Ram extends Sheep {

    public Ram() {
       this.setGender(Gender.MALE);
       this.setType(Type.RAM);
    }
    



}
