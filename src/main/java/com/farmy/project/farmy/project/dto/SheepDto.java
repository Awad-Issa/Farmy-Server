package com.farmy.project.farmy.project.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class SheepDto {


    @NotNull(message = "Sheep number cannot be null")
    @Positive(message = "Sheep number must be a positive number")
    private long num;

    private String age;

    @NotNull(message = "Sheep gender cannot be null")
    @Pattern(regexp = "MALE|FEMALE", message = "Gender must be either MALE or FEMALE!")
    private String gender;

    @NotNull(message = "Sheep status cannot be null")
    @Pattern(regexp = "HEALTHY|SICK|DIED|SOLD", message = "Status must be Healthy or sick or died or sold!")
    private String status;

    @PastOrPresent(message = "Birthdate must be in the past or today")
    private LocalDate birthDate;

    @DecimalMin(value = "0.0", inclusive = false, message = "Sheep weight must be positive")
    private double weight;



}

