package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.service.EweService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EweController {

    private final EweService eweService;

    @PostMapping("/addNewEwe")
    public ResponseEntity<EweDto> addNewEwe(@Valid @RequestBody EweDto eweDto) {
        eweService.addNewEwe(eweDto);
        return ResponseEntity.ok(eweDto);
    }


    @GetMapping("/getAllEwes")
    public List<EweDto> getAllEwes() {
        return eweService.getAllEwes();
    }

    @DeleteMapping("/removeEwe/{num}")
    public ResponseEntity<EweDto> removeEwe(@PathVariable long num) {
        eweService.removeEwe(num);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getEweByNum/{num}")
    public ResponseEntity<EweDto> getEweByNum(@PathVariable Long num) {
        EweDto eweDto = eweService.getEweByNum(num);
        if (eweDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(eweDto);
    }

    @PatchMapping("/editEwe/{num}")
    public ResponseEntity<EweDto> editEwe(@PathVariable("num") Long num, @RequestBody EweDto eweDto) {

        EweDto updatedEwe = eweService.editEwe(num, eweDto);

        if (updatedEwe != null) {
            return ResponseEntity.ok(updatedEwe);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
