package com.practice.insurance_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RefreshScope
@RestController
@RequestMapping("/client") // Base URL for the controller
public class ClientController {
    @Lazy
    private final RestTemplate restTemplate;
    private final String url;

    public ClientController(RestTemplate restTemplate, @Value("${insurance.provider.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @GetMapping("/getPlans")
    public List<String> getPlans() {
        return restTemplate.getForObject(url, List.class);
    }
}
