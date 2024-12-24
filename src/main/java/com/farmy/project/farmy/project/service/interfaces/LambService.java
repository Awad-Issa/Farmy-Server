package com.farmy.project.farmy.project.service.interfaces;

import com.farmy.project.farmy.project.dto.LambDto;

import java.util.List;

public interface LambService {

    List<LambDto> getAllLambs();

    void addNewLamb(LambDto lambDto);

    void removeLamb(Long id);

    LambDto editLamb(Long id, LambDto lambDto);

    LambDto getLambById(Long id);

}