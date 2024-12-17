package com.farmy.project.farmy.project.service.LambService;


import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.model.entity.Gender;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Status;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.LambRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImplLambService implements ILambService {

    private final LambRepo lambRepo;

    private final SheepMapper sheepMapper;

    @Override
    public List<LambDto> getAllLambs() {
        return lambRepo
                .findAll()
                .stream()
                .map(sheepMapper::toLambDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewLamb(LambDto lambDto) {
        Lamb lamb = new Lamb();

        lamb.setNum(lambDto.getNum());
        lamb.setAge(lambDto.getAge());
        lamb.setWeight(lambDto.getWeight());
        lamb.setBirthDate(lambDto.getBirthDate());
        lamb.setStatus(Status.valueOf(lambDto.getStatus()));
        lamb.setGender(Gender.valueOf(lambDto.getGender()));

        lambRepo.save(lamb);
    }


    @Override
    public LambDto removeLamb(long id) {
        Optional<Lamb> lamb = lambRepo.findById(id);
        if (lamb.isPresent()) {
            lambRepo.delete(lamb.get());
            return sheepMapper.toLambDto(lamb.get());
        }
        return null;
    }


    @Override
    public LambDto editLamb(long id, LambDto lambDto) {

        Optional<Lamb> exisitingLamb = lambRepo.findById(id);

        if (exisitingLamb.isPresent()) {
            Lamb lamb = exisitingLamb.get();

            lamb.setNum(lambDto.getNum());
            lamb.setWeight(lambDto.getWeight());
            lamb.setBirthDate(lambDto.getBirthDate());
            lamb.setGender(Gender.valueOf(lambDto.getGender()));
            lamb.setStatus(Status.valueOf(lambDto.getStatus()));

            Lamb updatedLamb = lambRepo.save(lamb);

            return LambDto.builder()
                    .num(updatedLamb.getNum())
                    .age(updatedLamb.getAge())
                    .birthDate(updatedLamb.getBirthDate())
                    .weight(updatedLamb.getWeight())
                    .gender(String.valueOf(updatedLamb.getGender()))
                    .status(String.valueOf(updatedLamb.getStatus()))
                    .build();
        }
        throw new NoSuchElementException("Lamb not found with id: " + id);

    }

    @Override
    public LambDto getLambById(long id) {
        return lambRepo.findById(id)
                .map(sheepMapper::toLambDto)
                .orElse(null);
    }


}
