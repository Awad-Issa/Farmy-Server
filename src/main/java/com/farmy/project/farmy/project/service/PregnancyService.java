package com.farmy.project.farmy.project.service;


import com.farmy.project.farmy.project.dto.PregnancyDto;
import com.farmy.project.farmy.project.model.entity.*;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import com.farmy.project.farmy.project.model.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PregnancyService implements com.farmy.project.farmy.project.service.interfaces.PregnancyService {


    private final EweRepo eweRepo;
    private final SpongeRepo spongeRepo;
    private final PregnancyRepo pregnancyRepo;
    private final InseminationRepo inseminationRepo;
    private final HormoneRepo hormoneRepo;


    @Override
    public void createPregnancy(PregnancyDto pregnancyDto) {

        Ewe ewe = null;
        if (pregnancyDto.getEweId()!= null) {
            ewe = eweRepo.findById(pregnancyDto.getEweId()).orElseThrow(() -> new IllegalArgumentException("Ewe not found with id: " + pregnancyDto.getEweId()));
        }

        Sponge sponge = null;
        if (pregnancyDto.getSpongeId() != null) {
            sponge = spongeRepo.findById(pregnancyDto.getSpongeId()).orElse(null);
        }

        Hormone hormone = null;
        if (pregnancyDto.getHormoneId() != null) {
            hormone = hormoneRepo.findById(pregnancyDto.getHormoneId()).orElse(null);
        }

        Insemination insemination = null;
        if (pregnancyDto.getInseminationId() != null) {
            insemination = inseminationRepo.findById(pregnancyDto.getInseminationId()).orElse(null);
        }

        Pregnancy pregnancy = new Pregnancy();

        pregnancy.setEwe(ewe);
        pregnancy.setSponge(sponge);
        pregnancy.setHormone(hormone);
        pregnancy.setInsemination(insemination);
        pregnancy.setStartDate(pregnancyDto.getStartDate());
        pregnancy.setEndDate(pregnancyDto.getEndDate());
        pregnancy.setExpectedBirthDate(pregnancyDto.getExpectedBirthDate());

        pregnancyRepo.save(pregnancy);
        if (ewe != null && ewe.getId() != null) {
            ewe.setPregnancyStatus(PregnancyStatus.ONGOING);
            eweRepo.save(ewe);
        }


    }


}
