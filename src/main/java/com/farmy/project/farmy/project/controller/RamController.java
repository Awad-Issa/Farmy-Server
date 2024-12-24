package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.service.RamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RamController {


    private final RamService ramService;

    @PostMapping("/addNewRam")
    public ResponseEntity<String> addNewRam(@Valid @RequestBody RamDto ramDto) {
        ramService.addNewRam(ramDto);
        return ResponseEntity.ok("Ram created successfully");
    }

    @GetMapping("/getAllRams")
    public List<RamDto> getAllRams() {
        return ramService.getAllRams();
    }

    @DeleteMapping("/removeRam/{id}")
    public ResponseEntity<RamDto> removeRam(@PathVariable long id) {
        ramService.removeRam(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getRam/{id}")
    public ResponseEntity<RamDto> getRamById(@PathVariable Long id) {
        RamDto ramDto = ramService.getRamById(id);
        if (ramDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ramDto);
    }

    @PatchMapping("/editRam/{id}")
    public ResponseEntity<RamDto> editRam(@PathVariable Long id, @RequestBody RamDto ramDto) {

        RamDto updatedRam = ramService.editRam(id, ramDto);

        if (updatedRam != null) {
            return ResponseEntity.ok(updatedRam);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }


}
