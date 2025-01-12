package com.farmy.project.farmy.project.service;

import com.farmy.project.farmy.project.dto.SpongeDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.entity.Sponge;
import com.farmy.project.farmy.project.model.entity.enums.PregnancyStatus;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import com.farmy.project.farmy.project.model.repository.SpongeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SpongeService implements com.farmy.project.farmy.project.service.interfaces.SpongeService {

    private final SpongeRepo spongeRepo;
    private final EweRepo eweRepo;

    @Override
    public void createSponge(SpongeDto spongeDto) {

        Ewe ewe = null;
        if (spongeDto.getEweId()!= null) {
            ewe = eweRepo.findById(spongeDto.getEweId())
                    .orElseThrow(() -> new IllegalArgumentException("Ewe not found with id: " + spongeDto.getEweId()));
        }
        if (ewe != null && ewe.getId() == null) {
            eweRepo.save(ewe);
        }
        Sponge sponge = new Sponge();
        sponge.setType(spongeDto.getType());
        sponge.setStartDate(spongeDto.getStartDate());
        sponge.setEndDate(spongeDto.getEndDate());
        sponge.setEwe(ewe);
        if (ewe != null) {
            ewe.addSponge(sponge);
        }
        spongeRepo.save(sponge);
        if (ewe != null && ewe.getId() != null) {
            ewe.setPregnancyStatus(PregnancyStatus.SPONGE);
            eweRepo.save(ewe);
        }

        spongeRepo.save(sponge);

    }
}
