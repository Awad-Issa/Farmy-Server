package com.farmy.project.farmy.project.service;

import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.SheepRepo;
import com.farmy.project.farmy.project.service.interfaces.ISheepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SheepService implements ISheepService {

    private final SheepRepo sheepRepo;

    private final SheepMapper sheepMapper;

    @Override
    public List<SheepDto> getAllSheep() {
        return sheepRepo
                .findAll()
                .stream()
                .map(sheepMapper::toDto)
                .collect(Collectors.toList());
    }
}
