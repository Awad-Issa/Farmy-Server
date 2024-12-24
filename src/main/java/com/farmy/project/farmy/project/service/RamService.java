package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.exception.RamNotFoundException;
import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.RamRepo;
import com.farmy.project.farmy.project.service.interfaces.IRamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RamService implements IRamService {

    private final RamRepo ramRepo;

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

        Ram ram = new Ram();

        ram.setNum(ramDto.getNum());
        ram.setWeight(ramDto.getWeight());
        ram.setBirthDate(ramDto.getBirthDate());
        ram.setStatus(ramDto.getStatus());

        if (ramDto.getGender() == null) {
            ram.setGender(Gender.MALE);
        } else {
            ram.setGender(Gender.MALE);
        }
        ramRepo.save(ram);
    }


    @Override
    public void removeRam(long num) {
        Optional<Ram> ram = ramRepo.findByNum(num);
        if (ram.isEmpty()) {
            throw new RamNotFoundException("Ram not found with num: " + num);
        }
        ram.ifPresent(ramRepo::delete);
    }


    @Override
    public RamDto editRam(Long num, RamDto ramDto) {
        Optional<Ram> existingRam = ramRepo.findByNum(num);
        if (existingRam.isPresent()) {
            sheepMapper.updateRam(existingRam.get(), ramDto);
            Ram updatedRam = ramRepo.save(existingRam.get());
            return sheepMapper.toDto(updatedRam);
        }
        throw new RamNotFoundException("Ram not found with num: " + num);
    }

    @Override
    public RamDto getRamByNum(Long num) {
        return ramRepo.findByNum(num)
                .map(sheepMapper::toDto)
                .orElse(null);
    }


}




















