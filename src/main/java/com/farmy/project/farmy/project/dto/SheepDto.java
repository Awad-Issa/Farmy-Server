package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.entity.Status;
import com.farmy.project.farmy.project.model.entity.Type;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class SheepDto {

    private Long num;

    private Gender gender;

    private Status status;

    private Type type;

    private LocalDate birthDate;

    private Double weight;

    private EweDto mother;



}

