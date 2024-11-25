
package com.farmy.project.farmy.project.service.RamService;

import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.model.entity.Ram;

import java.util.List;

public interface IRamService {

    List<RamDto> getAllRams();

    void addNewRam(RamDto ram);

    RamDto removeRam(long id);

    RamDto editRam(long id, RamDto ramDto);

    RamDto getRamById(long id);


}
