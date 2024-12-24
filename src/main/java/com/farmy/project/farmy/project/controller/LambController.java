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

    @DeleteMapping("/removeLamb/{id}")
    public ResponseEntity<LambDto> removeLamb(@PathVariable Long id) {
        lambService.removeLamb(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getLamb/{id}")
    public ResponseEntity<LambDto> getLambById(@PathVariable Long id) {
        LambDto lambDto = lambService.getLambById(id);
        if (lambDto == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.printf(String.valueOf(lambDto.getId()));
//        System.out.print(lambDto.getMother().getId());
        return ResponseEntity.ok(lambDto);
    }

    @PatchMapping("/editLamb/{id}")
    public ResponseEntity<LambDto> editLamb(@PathVariable Long id, @RequestBody LambDto lambDto) {

        LambDto updatedLamb = lambService.editLamb(id, lambDto);

        if (updatedLamb != null) {
            return ResponseEntity.ok(updatedLamb);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
