package com.farmy.project.farmy.project.service.EweService;

import com.farmy.project.farmy.project.model.entity.Ewe;

import java.util.List;

public interface IEweService {

    List<Ewe> getAllEwes();

    Ewe addNewEwe(Ewe ewe);

    Ewe removeEwe(long id);

    Ewe editEwe(Ewe ewe, long id);

    Ewe getEweById(long id);

    Ewe editEwe(long id, Ewe ewe);
}
