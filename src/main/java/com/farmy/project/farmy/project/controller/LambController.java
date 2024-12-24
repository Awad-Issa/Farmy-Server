package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.service.LambService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LambController {

    private final LambService lambService;

    @PostMapping("/addNewLamb")
    public ResponseEntity<LambDto> addNewLamb(@Valid @RequestBody LambDto lambDto) {
        lambService.addNewLamb(lambDto);
        return ResponseEntity.ok(lambDto);
    }

    @GetMapping("/getAllLambs")
    public List<LambDto> getAllLambs() {
        return lambService.getAllLambs();
    }

    @DeleteMapping("/removeLamb/{num}")
    public ResponseEntity<LambDto> removeLamb(@PathVariable Long num) {
        lambService.removeLamb(num);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getLambByNum/{num}")
    public ResponseEntity<LambDto> getLambByNum(@PathVariable Long num) {
        LambDto lambDto = lambService.getLambByNum(num);
        if (lambDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lambDto);
    }

    @PatchMapping("/editLamb/{num}")
    public ResponseEntity<LambDto> editLamb(@PathVariable Long num, @RequestBody LambDto lambDto) {

        LambDto updatedLamb = lambService.editLamb(num, lambDto);

        if (updatedLamb != null) {
            return ResponseEntity.ok(updatedLamb);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
