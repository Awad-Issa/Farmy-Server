package com.farmy.project.farmy.project.service.LambService;

import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.model.entity.Lamb;

import java.util.List;

public interface ILambService {

    List<LambDto> getAllLambs();

    void addNewLamb(LambDto lambDto);

    LambDto removeLamb(long id);

    LambDto editLamb(long id, LambDto lambDto);

    LambDto getLambById(long id);

}