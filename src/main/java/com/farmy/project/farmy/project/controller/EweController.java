package com.farmy.project.farmy.project.controller;

import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.service.EweService.ImplEweService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EweController {

    private final ImplEweService implEweService;

    @PostMapping("/addNewEwe")
    public Ewe addNewEwe(@RequestBody Ewe ewe){
        return implEweService.addNewEwe(ewe);
    }

    @GetMapping("/getAllEwes")
    public List<Ewe>getALLEwes(){
        return implEweService.getAllEwes();
    }




}
