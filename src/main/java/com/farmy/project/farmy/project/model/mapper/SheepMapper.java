package com.farmy.project.farmy.project.model.mapper;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Sheep;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SheepMapper {



//    SheepDto toDto(Sheep sheep);
//
//    Sheep toEntity(SheepDto sheepDto);

    EweDto toEweDto(Ewe ewe);

    Sheep toEweEntity(EweDto eweDto);

}

