package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.InseminationDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Insemination;
import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.InseminationRepo;
import com.farmy.project.farmy.project.model.repository.RamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InseminationService implements com.farmy.project.farmy.project.service.interfaces.InseminationService {

    private final InseminationRepo inseminationRepo;
    private final EweRepo eweRepo;
    private final RamRepo ramRepo;

    @Override
    public void addInsemination(InseminationDto inseminationDto) {

        Ewe ewe = null;
        if (inseminationDto.getEweId() != null) {
            ewe = eweRepo.findById(inseminationDto.getEweId()).orElseThrow(() -> new IllegalArgumentException("Ewe not found with id: " + inseminationDto.getEweId()));
        }
        if (ewe != null && ewe.getId() == null) {
            eweRepo.save(ewe);
        }

        Ram ram = null;
        if (inseminationDto.getRamId() != null) {
            ram = ramRepo.findById(inseminationDto.getRamId()).orElseThrow(() -> new IllegalArgumentException("Ram not found with id: " + inseminationDto.getRamId()));
        }
        if (ram != null && ram.getId() == null) {
            ramRepo.save(ram);
        }
        Insemination insemination = new Insemination();
        insemination.setDate(inseminationDto.getDate());
        insemination.setType(inseminationDto.getType());
        insemination.setRam(ram);
        insemination.setEwe(ewe);
        if (ewe != null) {
            ewe.addInsemination(insemination);
        }
        if (ram != null) {
            ram.addInsemination(insemination);
        }
        inseminationRepo.save(insemination);
        if (ewe != null && ewe.getId() != null) {
            ewe.setPregnancyStatus(PregnancyStatus.INSEMINATION);
            eweRepo.save(ewe);
        }
        if (ram != null && ram.getId() != null) {
            ramRepo.save(ram);
        }


    }
}
