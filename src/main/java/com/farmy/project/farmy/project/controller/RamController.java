package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.dto.RamDto;
import com.farmy.project.farmy.project.service.RamService.ImplRamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RamController {


    private final ImplRamService implRamService;

    @PostMapping("/addNewRam")
    public ResponseEntity<String> addNewRam(@Valid @RequestBody RamDto ramDto){
        implRamService.addNewRam(ramDto);
        return ResponseEntity.ok("Ram created successfully");
    }

    @GetMapping("/getAllRams")
    public List<RamDto> getAllRams(){
        return implRamService.getAllRams();
    }

    @DeleteMapping("/removeRam/{id}")
    public ResponseEntity<RamDto> removeRam(@PathVariable long id){
        RamDto removedRam = implRamService.removeRam(id);

        if (removedRam != null){
            return ResponseEntity.ok(removedRam);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/getRamById/{id}")
    public ResponseEntity<RamDto> getRamById(@PathVariable Long id){
        RamDto ramDto = implRamService.getRamById(id);
        if (ramDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ramDto);
    }

    @PutMapping("/editRam/{id}")
    public  ResponseEntity<RamDto> editRam(@PathVariable long id, @RequestBody RamDto ramDto){

        RamDto updatedRam = implRamService.editRam(id, ramDto);

        if (updatedRam != null){
            return ResponseEntity.ok(updatedRam);
        }
        else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }


}
