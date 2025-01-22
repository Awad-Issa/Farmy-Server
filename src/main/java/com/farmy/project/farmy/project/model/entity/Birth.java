package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Birth extends BaseEntity {

    @ManyToOne
    private Ewe ewe;

    @OneToMany
    private List<Lamb> lambs;

    @NotNull
    private LocalDate date;

    @OneToOne
    private Pregnancy pregnancy;


    public void addLambs(Lamb lamb){
        this.lambs.add(lamb);
    }

}
