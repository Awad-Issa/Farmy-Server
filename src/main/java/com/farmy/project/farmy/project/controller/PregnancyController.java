package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.PregnancyDto;
import com.farmy.project.farmy.project.service.PregnancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PregnancyController {

    private final PregnancyService pregnancyService;


    @PostMapping("/addPregnancy")
    public ResponseEntity<String> addSponge(@Valid @RequestBody PregnancyDto pregnancyDto){
        pregnancyService.createPregnancy(pregnancyDto);
        return ResponseEntity.ok("Pregnancy created successfully");
    }
}
