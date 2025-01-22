package com.farmy.project.farmy.project.service;

import com.farmy.project.farmy.project.dto.BirthDto;
import com.farmy.project.farmy.project.model.entity.Birth;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.entity.Pregnancy;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.BirthRepo;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.LambRepo;
import com.farmy.project.farmy.project.model.repository.PregnancyRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BirthService implements com.farmy.project.farmy.project.service.interfaces.BirthService {

    private final BirthRepo birthRepo;
    private final EweRepo eweRepo;
    private final PregnancyRepo pregnancyRepo;
    private final LambRepo lambRepo;
    private final SheepMapper sheepMapper;


    @Transactional
    @Override
    public void createBirth(BirthDto birthDto) {

        Ewe ewe;

        if (birthDto.getEweId() != null) {
            ewe = eweRepo.findById(birthDto.getEweId())
                    .orElseThrow(() -> new IllegalArgumentException("Ewe not found with id: " + birthDto.getEweId()));
        } else {
            ewe = null;
        }

        Pregnancy pregnancy = null;
        if (birthDto.getPregnancyId() != null) {
            pregnancy = pregnancyRepo.findById(birthDto.getPregnancyId())
                    .orElseThrow(() -> new IllegalArgumentException("pregnancy not found with id: " + birthDto.getPregnancyId()));
        }
        Birth birth = new Birth();
        birth.setDate(LocalDate.now());
        birth.setEwe(ewe);
        birth.setPregnancy(pregnancy);


        List<Lamb> lambs = birthDto.getLambs().stream()
                .map(sheepMapper::toEntity)
                .map(lamb -> fillDefaults(lamb, ewe))
                .map(lambRepo::save)
                .toList();
                birth.addLambs((Lamb) lambs);
    }

    private Lamb fillDefaults(Lamb lamb, Ewe ewe) {
        lamb.setMother(ewe);
        lamb.setBirthDate(LocalDate.now());
        return lamb;
    }


}
