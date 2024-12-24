package com.farmy.project.farmy.project.service.interfaces;

import com.farmy.project.farmy.project.dto.LambDto;

import java.util.List;

public interface ILambService {

    List<LambDto> getAllLambs();

    void addNewLamb(LambDto lambDto);

    void removeLamb(Long num);

    LambDto editLamb(Long num, LambDto lambDto);

    LambDto getLambByNum(Long num);

}