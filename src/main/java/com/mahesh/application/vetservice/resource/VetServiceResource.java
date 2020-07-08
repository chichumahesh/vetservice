package com.mahesh.application.vetservice.resource;

import com.mahesh.application.vetservice.model.Vet;
import com.mahesh.application.vetservice.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VetServiceResource {

    @Autowired
    VetService vetService;

    @GetMapping("/vets")
    public ResponseEntity<Vet> getVetService() {
        Vet vet = vetService.getVets();
        return new ResponseEntity(vet, HttpStatus.OK);
    }
}
