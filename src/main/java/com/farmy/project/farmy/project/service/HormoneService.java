package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.HormoneDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Hormone;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.HormoneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HormoneService implements com.farmy.project.farmy.project.service.interfaces.HormoneService {

    private final HormoneRepo hormoneRepo;
    private final EweRepo eweRepo;


    @Override
    public void createHormone(HormoneDto hormoneDto) {
        Ewe ewe = null;
        if (hormoneDto.getEweId() != null) {
            ewe = eweRepo.findById(hormoneDto.getEweId())
                    .orElseThrow(() -> new IllegalArgumentException("Ewe not found with id: " + hormoneDto.getEweId()));
        }
        if (ewe != null && ewe.getId() == null) {
            eweRepo.save(ewe);
        }
        Hormone hormone = new Hormone();
        hormone.setName(hormoneDto.getName());
        hormone.setDosage(hormoneDto.getDosage());
        hormone.setAdministrationDate(hormoneDto.getAdministrationDate());
        hormone.setEwe(ewe);
        if (ewe != null) {
            ewe.addHormone(hormone);
        }
        hormoneRepo.save(hormone);
        if (ewe != null && ewe.getId() != null) {
            ewe.setPregnancyStatus(PregnancyStatus.HORMONE);
            eweRepo.save(ewe);
        }
    }


}
