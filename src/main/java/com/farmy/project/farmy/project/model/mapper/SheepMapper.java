package com.farmy.project.farmy.project.model.mapper;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.Sheep;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SheepMapper {

    @Mapping(target = "mother", ignore = true)
    SheepDto toDto(Sheep sheep);

    default EweDto toDtoWithDepth(Sheep sheep, int depth) {
        if (sheep == null || depth <= 0) {
            return null;
        }
        SheepDto dto = toDto(sheep);
        dto.setMother(toDtoWithDepth(sheep.getMother(), depth - 1));
        return (EweDto) dto;
    }

    Sheep toEntity(SheepDto sheepDto);

    EweDto toDto(Ewe ewe);

    Sheep toEntity(EweDto eweDto);

    RamDto toDto(Ram ram);

    Sheep toEntity(RamDto ramDto);

    LambDto toDto(Lamb lamb);

    Sheep toEntity(LambDto lambDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRam(@MappingTarget Ram entity, RamDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEwe(@MappingTarget Ewe entity, EweDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLamb(@MappingTarget Lamb entity, LambDto dto);


}

