
package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.exception.EweNotFoundException;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.enums.Gender;
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

        Ewe mother = null;
        if (eweDto.getMother() != null) {
            mother = eweRepo.findById(eweDto.getMother().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Mother Ewe not found with id: " + eweDto.getMother()));
        }
        Ewe ewe = new Ewe();

        ewe.setNum(eweDto.getNum());
        ewe.setWeight(eweDto.getWeight());
        ewe.setBirthDate(eweDto.getBirthDate());
        ewe.setStatus(eweDto.getStatus());
        ewe.setPregnancyStatus(eweDto.getPregnancyStatus());

        if (eweDto.getGender() == null) {
            ewe.setGender(Gender.FEMALE);
        } else {
            ewe.setGender(Gender.FEMALE);
        }
        eweRepo.save(ewe);

        if (mother != null) {
            mother.addChild(ewe);
            eweRepo.save(mother);
        }
    }


    @Override
    public void removeEwe(long id) {
        Optional<Ewe> ewe = eweRepo.findById(id);
        if (ewe.isEmpty()) {
            throw new EweNotFoundException("Ewe not found with id: " + id);
        }
        ewe.ifPresent(eweRepo::delete);
    }


    @Override
    public EweDto editEwe(Long id, EweDto eweDto) {

        Optional<Ewe> existingEwe = eweRepo.findById(id);
        if (existingEwe.isPresent()) {
            sheepMapper.updateEwe(existingEwe.get(), eweDto);
            Ewe updatedEwe = eweRepo.save(existingEwe.get());
            return sheepMapper.toDto(updatedEwe);
        }
        throw new NoSuchElementException("Ewe not found with id: " + id);
    }


    @Override
    public EweDto getEweById(Long id) {
        return eweRepo.findById(id)
                .map(sheepMapper::toDto)
                .orElse(null);
    }

}
