package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.exception.LambNotFoundException;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.enums.Gender;
import com.farmy.project.farmy.project.model.entity.enums.Status;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.LambRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LambService implements com.farmy.project.farmy.project.service.interfaces.LambService {

    private final LambRepo lambRepo;
    private final EweRepo eweRepo;
    private final SheepMapper sheepMapper;

    @Override
    public List<LambDto> getAllLambs() {
        return lambRepo
                .findAll()
                .stream()
                .map(sheepMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewLamb(LambDto lambDto) {

        Ewe mother = null;
        if (lambDto.getMother() != null) {
            mother = eweRepo.findById(lambDto.getMother().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Mother Ewe not found with id: " + lambDto.getMother()));
        }

        Lamb lamb = new Lamb();

        lamb.setNum(lambDto.getNum());
        lamb.setWeight(lambDto.getWeight());
        lamb.setBirthDate(lambDto.getBirthDate());
        lamb.setStatus(Status.valueOf(String.valueOf(lambDto.getStatus())));
        lamb.setGender(Gender.valueOf(String.valueOf(lambDto.getGender())));
        lamb.setMother(mother);
        lamb = lambRepo.save(lamb);

        if (mother != null) {
            mother.addChild(lamb);
            eweRepo.save(mother);
        }

    }


    @Override
    public void removeLamb(Long id) {
        Optional<Lamb> lamb = lambRepo.findById(id);
        if (lamb.isEmpty()) {
            throw new LambNotFoundException("Lamb not found with id: " + id);

        }
        lamb.ifPresent(lambRepo::delete);
    }


    @Override
    public LambDto editLamb(Long id, LambDto lambDto) {

        Optional<Lamb> existingLamb = lambRepo.findById(id);

        if (existingLamb.isPresent()) {
            sheepMapper.updateLamb(existingLamb.get(), lambDto);
            Lamb updatedLamb = lambRepo.save(existingLamb.get());
            return sheepMapper.toDto(updatedLamb);
        }
        throw new NoSuchElementException("Lamb not found with id: " + id);

    }

    @Override
    public LambDto getLambById(Long id) {
        return lambRepo.findById(id)
                .map(sheepMapper::toDto)
                .orElse(null);
    }

}
