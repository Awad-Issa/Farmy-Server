package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.SpongeDto;
import com.farmy.project.farmy.project.service.SpongeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpongeController {


    private final SpongeService spongeService;

    @PostMapping("/addSponge")
    public ResponseEntity<String> addSponge(@Valid @RequestBody SpongeDto spongeDto){
        spongeService.createSponge(spongeDto);
        return ResponseEntity.ok("Sponge created successfully");
    }
}
