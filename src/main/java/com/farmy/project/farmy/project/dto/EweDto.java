package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.enums.Pregnancy;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@SuperBuilder
@NoArgsConstructor
@Data
public class EweDto extends SheepDto {


    private List<SheepDto> children;

    private Pregnancy pregnancyStatus;


}
