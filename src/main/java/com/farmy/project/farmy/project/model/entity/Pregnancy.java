package com.farmy.project.farmy.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pregnancy")
public class Pregnancy extends BaseEntity {

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ewe ewe;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;


    private Date expectedBirthDate;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sponge_id", referencedColumnName = "id")
    private Sponge sponge;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hormone_id", referencedColumnName = "id")
    private Hormone hormone;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insemination_id", referencedColumnName = "id")
    private Insemination insemination;

    @PrePersist
    @PreUpdate
    private void calculateDates() {
        if (insemination != null && insemination.getDate() != null) {
            // Set startDate to the insemination date
            startDate = insemination.getDate();

            // Calculate expectedBirthDate
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_YEAR, 150);
            expectedBirthDate = calendar.getTime();
        }
    }
}