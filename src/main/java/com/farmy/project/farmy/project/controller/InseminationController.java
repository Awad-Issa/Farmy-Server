package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.InseminationDto;
import com.farmy.project.farmy.project.dto.SpongeDto;
import com.farmy.project.farmy.project.service.InseminationService;
import com.farmy.project.farmy.project.service.SpongeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InseminationController {

    private final InseminationService inseminationService;

    @PostMapping("/addIns")
    public ResponseEntity<String> addSponge(@Valid @RequestBody InseminationDto inseminationDto){
        inseminationService.addInsemination(inseminationDto);
        return ResponseEntity.ok("Insemination created successfully");
    }

}


