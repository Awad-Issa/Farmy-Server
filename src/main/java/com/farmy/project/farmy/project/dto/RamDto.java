package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Gender;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
public class RamDto extends SheepDto {

    public RamDto() {
        setGender(String.valueOf(Gender.MALE));
    }

}