package com.farmy.project.farmy.project.model.mapper;

import com.farmy.project.farmy.project.dto.*;
import com.farmy.project.farmy.project.model.entity.*;
import org.hibernate.query.BindableType;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SheepMapper {

    Sheep toEntity(SheepDto sheepDto);

    Ewe toEwe(Lamb lamb);

    Ram toRam(Lamb lamb);

    EweDto toDto(Ewe ewe);

    Sheep toEntity(EweDto eweDto);

    RamDto toDto(Ram ram);

    Sheep toEntity(RamDto ramDto);

    LambDto toDto(Lamb lamb);

    Lamb toEntity(LambDto lambDto);

    Hormone toEntity(HormoneDto hormoneDto);

    HormoneDto toDto(Hormone hormone);

    Sponge toEntity(SpongeDto spongeDto);

    SpongeDto toDto(SpongeDto spongeDto);

    Insemination toEntity(InseminationDto inseminationDto);

    InseminationDto toDto(Insemination insemination);

    Pregnancy toEntity(PregnancyDto pregnancyDto);

    PregnancyDto toDto(Pregnancy pregnancy);

    Birth toEntity(BirthDto birthDto);

    BirthDto toDto(Birth birth);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRam(@MappingTarget Ram entity, RamDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEwe(@MappingTarget Ewe entity, EweDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLamb(@MappingTarget Lamb entity, LambDto dto);


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
}

