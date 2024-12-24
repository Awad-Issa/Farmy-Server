package com.farmy.project.farmy.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@SuperBuilder
@NoArgsConstructor
@Data

public class EweDto extends SheepDto {



    private List<SheepDto> children; // List of children (Lamb, Ewe, Ram)



}
