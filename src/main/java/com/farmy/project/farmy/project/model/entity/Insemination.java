package com.farmy.project.farmy.project.model.entity;

import com.farmy.project.farmy.project.model.entity.enums.InseminationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insemination extends BaseEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ewe ewe;

    @Enumerated(EnumType.STRING)
    private InseminationType type;

    @NotNull
    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ram ram;


}
