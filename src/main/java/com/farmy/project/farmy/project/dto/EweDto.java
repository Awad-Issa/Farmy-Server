package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.entity.Pregnancy;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data

public class EweDto extends SheepDto {

    public EweDto() {
        setGender(String.valueOf(Gender.FEMALE));
    }


//    @NotNull(message = "EWE's Pregnancy Status cannot be null")
//    @Pattern(regexp = "PREGNANT|REST|SHR", message = "Pregnancy Status must be PREGNANT or REST or SHR!")
//    private String PregnancyStatus;


}
