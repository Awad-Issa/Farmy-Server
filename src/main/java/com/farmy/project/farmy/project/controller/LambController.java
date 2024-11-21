package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.service.LambService.ImpleLambService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LambController {

    private final ImpleLambService implLambService;

    @PostMapping("/addNewLamb")
    public Lamb addNewLamb(@RequestBody Lamb lamb) {
        return implLambService.addNewLamb(lamb);
    }



}
