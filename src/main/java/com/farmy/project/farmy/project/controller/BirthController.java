package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.BirthDto;
import com.farmy.project.farmy.project.service.BirthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BirthController {

    private final BirthService birthService;

    @PostMapping("/addBirth")
    public ResponseEntity<BirthDto> addBirth(@Valid @RequestBody BirthDto birthDto) {
        birthService.createBirth(birthDto);
        return ResponseEntity.ok(birthDto);
    }

}
