package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
public class LambDto extends SheepDto {


    public LambDto(){
        setGender(getGender());
    }


}
