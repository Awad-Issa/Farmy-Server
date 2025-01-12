package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.HormoneDto;
import com.farmy.project.farmy.project.service.HormoneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HormoneController {

    private final HormoneService hormoneService;

    @PostMapping("/addHormone")
    public ResponseEntity<String> addSponge(@Valid @RequestBody HormoneDto hormoneDto){
        hormoneService.createHormone(hormoneDto);
        return ResponseEntity.ok("Hormone created successfully");
    }
}
