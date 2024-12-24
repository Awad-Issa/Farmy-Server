
package com.farmy.project.farmy.project.service.interfaces;

import com.farmy.project.farmy.project.dto.EweDto;

import java.util.List;

public interface EweService {


    List<EweDto> getAllEwes();

    void addNewEwe(EweDto eweDto);

    EweDto editEwe(Long id, EweDto eweDto);

    void removeEwe(long id);

    EweDto getEweById(Long id);
}
