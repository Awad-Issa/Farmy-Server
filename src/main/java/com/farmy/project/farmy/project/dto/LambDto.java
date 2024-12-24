package com.farmy.project.farmy.project.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
public class LambDto extends SheepDto {


    public LambDto() {
        setGender(getGender());

    }


}
