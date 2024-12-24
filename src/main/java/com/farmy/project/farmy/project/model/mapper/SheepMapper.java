package com.farmy.project.farmy.project.model.mapper;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.Sheep;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SheepMapper {

    SheepDto toDto(Sheep sheep);

    Sheep toEntity(SheepDto sheepDto);

    EweDto toDto(Ewe ewe);

    Sheep toEntity(EweDto eweDto);

    RamDto toDto(Ram ram);

    Sheep toEntity(RamDto ramDto);

    LambDto toDto(Lamb lamb);

    Sheep toEntity(LambDto lambDto);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void updateRam(@MappingTarget Ram entity, RamDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void updateEwe(@MappingTarget Ewe entity, EweDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void updateLamb(@MappingTarget Lamb entity, LambDto dto);



}

