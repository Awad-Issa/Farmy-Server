package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("LAMB")
public class Lamb extends Sheep{




}
