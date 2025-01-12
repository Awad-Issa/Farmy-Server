package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Insemination;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@SuperBuilder
@NoArgsConstructor
@Data
public class RamDto extends SheepDto {


    private List<Insemination> insemination;



}