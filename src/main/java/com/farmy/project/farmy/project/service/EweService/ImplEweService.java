
package com.farmy.project.farmy.project.service.EweService;


import com.farmy.project.farmy.project.dto.EweDto;
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
public class ImplEweService implements IEweService {

    private final EweRepo eweRepo;

    private final SheepMapper sheepMapper;


    @Override
    public List<EweDto> getAllEwes() {
        return eweRepo
                .findAll()
                .stream()
                .map(sheepMapper::toEweDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addNewEwe(EweDto eweDto) {
        Ewe ewe = new Ewe();
        ewe.setNum(eweDto.getNum());
        ewe.setAge(eweDto.getAge());
        ewe.setWeight(eweDto.getWeight());
        ewe.setBirthDay(eweDto.getBirthDay());

        if (eweDto.getGender() == null) {
            ewe.setGender(Gender.valueOf("FEMALE"));
        } else {
            ewe.setGender(Gender.valueOf(eweDto.getGender()));
        }

        eweRepo.save(ewe);
    }

    @Override
    public EweDto removeEwe(long id) {
        Optional<Ewe> ewe = eweRepo.findById(id);
        if (ewe.isPresent()) {
            eweRepo.delete(ewe.get());
            return sheepMapper.toEweDto(ewe.get());
        }
        return null;
    }


    @Override
    public EweDto editEwe(long id, EweDto eweDto) {
        Optional<Ewe> existingEwe = eweRepo.findById(id);

        if (existingEwe.isPresent()) {
            Ewe ewe = existingEwe.get();

            ewe.setNum(eweDto.getNum());
            ewe.setAge(eweDto.getAge());
            ewe.setBirthDay(eweDto.getBirthDay());
            ewe.setWeight(eweDto.getWeight());
            ewe.setGender(Gender.FEMALE);

            Ewe updatedEwe = eweRepo.save(ewe);

            return EweDto.builder()
                    .num(updatedEwe.getNum())
                    .age(updatedEwe.getAge())
                    .birthDay(updatedEwe.getBirthDay())
                    .weight(updatedEwe.getWeight())
                    .gender(String.valueOf(Gender.FEMALE))
                    .build();
        }

        throw new NoSuchElementException("Ewe not found with id: " + id);
    }


    @Override
    public EweDto getEweById(long id) {
        return eweRepo.findById(id)
                .map(sheepMapper::toEweDto)
                .orElse(null);
    }

}
