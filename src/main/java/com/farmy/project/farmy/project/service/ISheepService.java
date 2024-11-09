package com.farmy.project.farmy.project.service;

import com.farmy.project.farmy.project.model.entity.Sheep;

import java.util.List;

public interface ISheepService {


    List<Sheep> getAllSheeps();

    Sheep addNewSheep(Sheep sheep);

    Sheep removeSheep(long id);

    Sheep editSheep(long id, Sheep sheep);

    Sheep getSheepById(Long id);

}
