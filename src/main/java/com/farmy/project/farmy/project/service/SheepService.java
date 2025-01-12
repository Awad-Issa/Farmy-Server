package com.farmy.project.farmy.project.service;

import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.exception.LambNotFoundException;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import com.farmy.project.farmy.project.model.entity.enums.Type;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.LambRepo;
import com.farmy.project.farmy.project.model.repository.RamRepo;
import com.farmy.project.farmy.project.model.repository.SheepRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SheepService implements com.farmy.project.farmy.project.service.interfaces.SheepService {

    private final SheepRepo sheepRepo;
    private final LambRepo lambRepo;
    private final EweRepo eweRepo;
    private final RamRepo ramRepo;

    private final SheepMapper sheepMapper;

    @Override
    public List<SheepDto> getAllSheep() {
        return sheepRepo
                .findAll()
                .stream()
                .map(sheepMapper::toDto)
                .collect(Collectors.toList());
    }

    public SheepDto promoteLamb(Long id) {
        Lamb lamb = lambRepo.findById(id)
                .orElseThrow(() -> new LambNotFoundException("Lamb not found"));


        SheepDto promotedSheep = null;
        if (lamb.getGender() == Gender.FEMALE) {
            Ewe ewe = sheepMapper.toEwe(lamb);
            ewe.setPregnancyStatus(PregnancyStatus.REST);
            ewe.setType(Type.EWE);
            eweRepo.save(ewe);
            promotedSheep = sheepMapper.toDto(ewe);
        } else if (lamb.getGender() == Gender.MALE) {
            Ram ram = sheepMapper.toRam(lamb);
            ram.setType(Type.RAM);
            ramRepo.save(ram);
            promotedSheep = sheepMapper.toDto(ram);
        } else {
            throw new IllegalArgumentException("Lamb gender is undefined, cannot promote.");
        }
        sheepRepo.delete(lamb);
        return promotedSheep;
    }

}


