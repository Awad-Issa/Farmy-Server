package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.service.RamService.ImplRamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RamController {


    private final ImplRamService implRamService;

    @PostMapping("/addNewRam")
    public Ram addNewRam(@RequestBody Ram ram) {
        return implRamService.addNewRam(ram);
    }



}
