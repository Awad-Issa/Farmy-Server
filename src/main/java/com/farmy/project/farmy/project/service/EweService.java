
package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.exception.EweNotFoundException;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EweService implements com.farmy.project.farmy.project.service.interfaces.EweService {

    private final EweRepo eweRepo;

    private final SheepMapper sheepMapper;


    @Override
    public List<EweDto> getAllEwes() {
        return eweRepo
                .findAll()
                .stream()
                .map(sheepMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewEwe(EweDto eweDto) {

        Ewe ewe = new Ewe();

        ewe.setNum(eweDto.getNum());
        ewe.setWeight(eweDto.getWeight());
        ewe.setBirthDate(eweDto.getBirthDate());
        ewe.setStatus(eweDto.getStatus());

        if (eweDto.getGender() == null) {
            ewe.setGender(Gender.FEMALE);
        } else {
            ewe.setGender(Gender.FEMALE);
        }
        eweRepo.save(ewe);
    }


    @Override
    public void removeEwe(long num) {
        Optional<Ewe> ewe = eweRepo.findByNum(num);
        if (ewe.isEmpty()) {
            throw new EweNotFoundException("Ewe not found with num: " + num);
        }
        ewe.ifPresent(eweRepo::delete);
    }


    @Override
    public EweDto editEwe(Long num, EweDto eweDto) {

        Optional<Ewe> existingEwe = eweRepo.findByNum(num);
        if (existingEwe.isPresent()) {
            sheepMapper.updateEwe(existingEwe.get(), eweDto);
            Ewe updatedEwe = eweRepo.save(existingEwe.get());
            return sheepMapper.toDto(updatedEwe);
        }
        throw new NoSuchElementException("Ewe not found with num: " + num);
    }


    @Override
    public EweDto getEweByNum(Long num) {
        return eweRepo.findByNum(num)
                .map(sheepMapper::toDto)
                .orElse(null);
    }

}
