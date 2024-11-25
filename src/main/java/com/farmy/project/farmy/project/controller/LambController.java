package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.LambDto;
import com.farmy.project.farmy.project.service.LambService.ImplLambService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LambController {

    private final ImplLambService implLambService;

    @PostMapping("/addNewLamb")
    public ResponseEntity<String> addNewLamb(@Valid @RequestBody LambDto lambDto) {
        implLambService.addNewLamb(lambDto);
        return ResponseEntity.ok("Lamb created successfully");
    }

    @GetMapping("/getAllLambs")
    public List<LambDto> getAllLambs() {
        return implLambService.getAllLambs();
    }

    @DeleteMapping("/removeLamb/{id}")
    public ResponseEntity<LambDto> removeLamb(@PathVariable long id) {
        LambDto removedLamb = implLambService.removeLamb(id);

        if (removedLamb != null) {
            return ResponseEntity.ok(removedLamb);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getLambById/{id}")
    public ResponseEntity<LambDto> getLambById(@PathVariable long id) {
        LambDto lambDto = implLambService.getLambById(id);
        if (lambDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lambDto);
    }

    @PutMapping("/editLamb/{id}")
    public ResponseEntity<LambDto> editLamb(@PathVariable Long id, @RequestBody LambDto lambDto) {

        LambDto updatedLamb = implLambService.editLamb(id, lambDto);

        if (updatedLamb != null) {
            return ResponseEntity.ok(updatedLamb);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
