
package com.farmy.project.farmy.project.service.EweService;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.model.entity.Ewe;

import java.util.List;

public interface IEweService {


    List<EweDto> getAllEwes();

    void addNewEwe(EweDto eweDto);

    EweDto editEwe(long id, EweDto eweDto);

    EweDto removeEwe(long id);

    EweDto getEweById(long id);
}
