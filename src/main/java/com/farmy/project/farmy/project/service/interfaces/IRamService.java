
package com.farmy.project.farmy.project.service.interfaces;

import com.farmy.project.farmy.project.dto.RamDto;

import java.util.List;

public interface IRamService {

    List<RamDto> getAllRams();

    void addNewRam(RamDto ram);

    void removeRam(long id);

    RamDto editRam(Long num, RamDto ramDto);

    RamDto getRamByNum(Long num);


}
