package com.practice.insurance_config_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/insurance-service")
public class ConfigController {
    @GetMapping("/getAllPlans")
    public List<String> getPlans(){
        return Stream.of("Premium","Gold","Platinum").collect(Collectors.toList());
    }
}
