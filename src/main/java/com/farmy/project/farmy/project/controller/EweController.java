package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.EweDto;
import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.service.EweService.ImplEweService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EweController {

    private final ImplEweService implEweService;

    @PostMapping("/addNewEwe")
    public ResponseEntity<String> addNewEwe(@Valid @RequestBody EweDto eweDto){
        implEweService.addNewEwe(eweDto);
        return ResponseEntity.ok("Ewe created successfully");
    }


    @GetMapping("/getAllEwes")
    public List<EweDto> getAllEwes() {
        return implEweService.getAllEwes();
    }

    @DeleteMapping("/removeEwe/{id}")
    public ResponseEntity<EweDto> removeEwe(@PathVariable long id) {
        EweDto removedEwe = implEweService.removeEwe(id);
        if (removedEwe != null) {
            return ResponseEntity.ok(removedEwe);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getEweById/{id}")
    public ResponseEntity<EweDto> getEweById(@PathVariable Long id) {
        EweDto eweDto = implEweService.getEweById(id);
        if (eweDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eweDto);
    }

    @PutMapping("/editEwe/{id}")
    public ResponseEntity<EweDto> editEwe(@PathVariable("id") Long id, @RequestBody EweDto eweDto) {

        EweDto updatedEwe = implEweService.editEwe(id, eweDto);

        if (updatedEwe != null) {
            return ResponseEntity.ok(updatedEwe);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
