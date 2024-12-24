package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.exception.RamNotFoundException;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.RamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RamService implements com.farmy.project.farmy.project.service.interfaces.RamService {

    private final RamRepo ramRepo;
    private final EweRepo eweRepo;
    private final SheepMapper sheepMapper;

    @Override
    public List<RamDto> getAllRams() {
        return ramRepo
                .findAll()
                .stream()
                .map(sheepMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewRam(RamDto ramDto) {

        Ewe mother = null;
        if(ramDto.getMother() != null){
            mother = eweRepo.findById(ramDto.getMother().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Mother Ewe not found with id: " + ramDto.getMother()));
        }

        Ram ram = new Ram();

        ram.setNum(ramDto.getNum());
        ram.setWeight(ramDto.getWeight());
        ram.setBirthDate(ramDto.getBirthDate());
        ram.setStatus(ramDto.getStatus());
        ram.setMother(mother);
        if (ramDto.getGender() == null) {
            ram.setGender(Gender.MALE);
        } else {
            ram.setGender(Gender.MALE);
        }
        ramRepo.save(ram);

        if (mother != null) {
            mother.addChild(ram);
            eweRepo.save(mother);
        }
    }


    @Override
    public void removeRam(long id) {
        Optional<Ram> ram = ramRepo.findById(id);
        if (ram.isEmpty()) {
            throw new RamNotFoundException("Ram not found id: " + id);
        }
        ram.ifPresent(ramRepo::delete);
    }


    @Override
    public RamDto editRam(Long id, RamDto ramDto) {
        Optional<Ram> existingRam = ramRepo.findById(id);
        if (existingRam.isPresent()) {
            sheepMapper.updateRam(existingRam.get(), ramDto);
            Ram updatedRam = ramRepo.save(existingRam.get());
            return sheepMapper.toDto(updatedRam);
        }
        throw new RamNotFoundException("Ram not found with id: " + id);
    }

    @Override
    public RamDto getRamById(Long id) {
        return ramRepo.findById(id)
                .map(sheepMapper::toDto)
                .orElse(null);
    }


}




















