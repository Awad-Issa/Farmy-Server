package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@Entity
public class Lamb extends Sheep {

    public Lamb(){
        this.setType(Type.LAMB);
    }


}


