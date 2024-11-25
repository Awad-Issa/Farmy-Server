package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Gender;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data

public class EweDto extends SheepDto {

    public EweDto() {
        setGender(String.valueOf(Gender.FEMALE));
    }

}
