package com.mahesh.application.vetservice.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VetServiceResource {

    @Value("${my.grade}")
    private String grade;

    @Value("${my.name}")
    private String name;

    @Value("${my.abc}")
    private String abc;

    @GetMapping("/vets")
    public String getVetService() {
         return grade + "..."+ name + " "+abc;
    }
}
