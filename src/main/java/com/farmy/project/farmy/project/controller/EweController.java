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

    @DeleteMapping("/removeEwe/{id}")
    public ResponseEntity<EweDto> removeEwe(@PathVariable long id) {
        eweService.removeEwe(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getEwe/{id}")
    public ResponseEntity<EweDto> getEweById(@PathVariable long id) {
        EweDto eweDto = eweService.getEweById(id);
        if (eweDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(eweDto);
    }

    @PatchMapping("/editEwe/{id}")
    public ResponseEntity<EweDto> editEwe(@PathVariable("id") Long id, @RequestBody EweDto eweDto) {

        EweDto updatedEwe = eweService.editEwe(id, eweDto);

        if (updatedEwe != null) {
            return ResponseEntity.ok(updatedEwe);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
