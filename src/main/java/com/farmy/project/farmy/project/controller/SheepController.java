package com.farmy.project.farmy.project.controller;


import com.farmy.project.farmy.project.dto.SheepDto;
import com.farmy.project.farmy.project.service.SheepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SheepController {

    private final SheepService sheepService;

    @GetMapping("/getAllSheep")
    public List<SheepDto> getAllSheep() {
        return sheepService.getAllSheep();
    }


    @PostMapping("/{id}/promote")
    public String promoteSheep(@PathVariable Long id) {
        // Just a simple test to ensure the method is being called
        sheepService.promoteLamb(id);
        System.out.println("Promoting sheep with ID: " + id);
        return "Sheep with ID " + id + " promoted!";
    }

}
