package com.farmy.project.farmy.project.model.mapper;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.Sheep;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SheepMapper {


    EweDto toEweDto(Ewe ewe);

    Sheep toEweEntity(EweDto eweDto);

    RamDto toRamDto (Ram ram);

    Sheep toRamEntity(RamDto ramDto);

    LambDto toLambDto(Lamb lamb);

    Sheep toLambEntity(LambDto lambDto);




}

