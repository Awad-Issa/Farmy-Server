package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("RAM")
public class Ram extends Sheep {


}
