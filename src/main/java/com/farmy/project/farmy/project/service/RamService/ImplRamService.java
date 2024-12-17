package com.farmy.project.farmy.project.service.RamService;


import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.Status;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.RamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImplRamService implements IRamService {

    private final RamRepo ramRepo;

    private final SheepMapper sheepMapper;

    @Override
    public List<RamDto> getAllRams() {
        return ramRepo
                .findAll()
                .stream()
                .map(sheepMapper::toRamDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewRam(RamDto ramDto) {

        Ram ram = new Ram();

        ram.setNum(ramDto.getNum());
        ram.setAge(ramDto.getAge());
        ram.setWeight(ramDto.getWeight());
        ram.setBirthDate(ramDto.getBirthDate());
        ram.setStatus(Status.valueOf(ramDto.getStatus()));

        if (ramDto.getGender() == null) {
            ram.setGender(Gender.MALE);
        } else {
            ram.setGender(Gender.MALE);
        }
        ramRepo.save(ram);
    }


    @Override
    public RamDto removeRam(long id) {
        Optional<Ram> ram = ramRepo.findById(id);
        if (ram.isPresent()) {
            ramRepo.delete(ram.get());
            return sheepMapper.toRamDto(ram.get());
        }
        return null;
    }


    @Override
    public RamDto editRam(long id, RamDto ramDto) {
        Optional<Ram> existingRam = ramRepo.findById(id);

        if (existingRam.isPresent()) {
            Ram ram = existingRam.get();

            ram.setNum(ramDto.getNum());
            ram.setBirthDate(ramDto.getBirthDate());
            ram.setWeight(ramDto.getWeight());
            ram.setGender(Gender.MALE);
            ram.setStatus(Status.valueOf(ramDto.getStatus()));

            Ram updatedRam = ramRepo.save(ram);

            return RamDto.builder()
                    .num(updatedRam.getNum())
                    .age(updatedRam.getAge())
                    .birthDate(updatedRam.getBirthDate())
                    .weight(updatedRam.getWeight())
                    .gender(String.valueOf(updatedRam.getGender()))
                    .status(String.valueOf(updatedRam.getStatus()))
                    .build();
        }

        throw new NoSuchElementException("Ram not found with id: " + id);
    }

    @Override
    public RamDto getRamById(long id) {
        return ramRepo.findById(id)
                .map(sheepMapper::toRamDto)
                .orElse(null);
    }


}




















