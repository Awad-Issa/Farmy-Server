package com.farmy.project.farmy.project.service;

import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.model.entity.Sheep;
import com.farmy.project.farmy.project.model.repository.SheepRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SheepService implements ISheepService {

    private final SheepRepo sheepRepo;

    @Override
    public List<Sheep> getAllSheeps() {
        SheepDto sheepDto = SheepDto.builder()
                .age(1).build();
        return sheepRepo.findAll();
    }

    @Override
    public Sheep addNewSheep(Sheep sheep) {
        return sheepRepo.save(sheep);
    }

    @Override
    public Sheep removeSheep(long id) {
         sheepRepo.deleteById(id);
        return null;
    }

    @Override
    public Sheep editSheep(long id, Sheep sheep) {
        return sheepRepo.save(sheep);
    }

    @Override
    public Sheep getSheepById(Long id) {
        return sheepRepo.getById(id);
    }
}