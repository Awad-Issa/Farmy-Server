package com.farmy.project.farmy.project.dto;

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


    @NotNull(message = "Sheep number cannot be null")
    @Positive(message = "Sheep number must be a positive number")
    private long num;

    @Min(value = 0, message = "Sheep age cannot be negative")
    @Max(value = 240, message = "Sheep age cannot exceed 240 months (20 years)")
    private int age;  // Age in months

    @NotNull(message = "Sheep gender cannot be null")
    @Pattern(regexp = "MALE|FEMALE", message = "Gender must be either MALE or FEMALE")
    private String gender;

    @PastOrPresent(message = "Birthdate must be in the past or today")
    private LocalDate birthDay;

    @DecimalMin(value = "0.0", inclusive = false, message = "Sheep weight must be positive")
    private double weight;
}

