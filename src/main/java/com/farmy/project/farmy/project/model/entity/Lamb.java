package com.farmy.project.farmy.project.model.entity;

import com.farmy.project.farmy.project.model.entity.enums.Type;
import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity
public class Lamb extends Sheep {

    public Lamb() {
        this.setType(Type.LAMB);
    }



}


