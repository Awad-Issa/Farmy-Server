package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.exception.EweNotFoundException;
import com.farmy.project.farmy.project.exception.LambNotFoundException;
import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Status;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.LambRepo;
import com.farmy.project.farmy.project.service.interfaces.ILambService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LambService implements ILambService {

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

        Lamb lamb = new Lamb();

        lamb.setNum(lambDto.getNum());
        lamb.setWeight(lambDto.getWeight());
        lamb.setBirthDate(lambDto.getBirthDate());
        lamb.setStatus(Status.valueOf(String.valueOf(lambDto.getStatus())));
        lamb.setGender(Gender.valueOf(String.valueOf(lambDto.getGender())));
        lambRepo.save(lamb);
    }




    @Override
    public void removeLamb(Long num) {
        Optional<Lamb> lamb = lambRepo.findByNum(num);
        if (lamb.isEmpty()) {
            throw new LambNotFoundException("Lamb not found with num: " + num);

        }
        lamb.ifPresent(lambRepo::delete);
    }


    @Override
    public LambDto editLamb(Long num, LambDto lambDto) {

        Optional<Lamb> existingLamb = lambRepo.findByNum(num);

        if (existingLamb.isPresent()) {
            sheepMapper.updateLamb(existingLamb.get(), lambDto);
            Lamb updatedLamb = lambRepo.save(existingLamb.get());
            return sheepMapper.toDto(updatedLamb);
        }
        throw new NoSuchElementException("Lamb not found with num: " + num);

    }

    @Override
    public LambDto getLambByNum(Long num) {
        return lambRepo.findByNum(num)
                .map(sheepMapper::toDto)
                .orElse(null);
    }


}
