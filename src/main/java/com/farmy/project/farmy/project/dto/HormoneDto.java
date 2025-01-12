package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Ewe;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@Data
public class HormoneDto {

    private Long id;

    private String name;

    private String dosage;

    private Long eweId;

    private Date administrationDate;
}
