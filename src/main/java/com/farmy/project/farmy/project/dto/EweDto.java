package com.farmy.project.farmy.project.dto;

import com.farmy.project.farmy.project.model.entity.Hormone;
import com.farmy.project.farmy.project.model.entity.Insemination;
import com.farmy.project.farmy.project.model.entity.Sponge;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@SuperBuilder
@NoArgsConstructor
@Data
public class EweDto extends SheepDto {


    private List<SheepDto> children;
//
    private PregnancyStatus pregnancyStatus;
//
//    private List<PregnancyDto> pregnancies;
//
    private List<SpongeDto> sponges;
//
    private List<HormoneDto> hormones;
//
//    private List<InseminationDto> insemination;



}
