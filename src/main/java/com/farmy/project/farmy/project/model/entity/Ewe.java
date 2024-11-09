package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@DiscriminatorValue("EWE")
@Entity
public class Ewe extends Sheep{



}
