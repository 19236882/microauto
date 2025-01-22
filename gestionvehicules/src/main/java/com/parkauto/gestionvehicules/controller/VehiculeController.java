package com.parkauto.gestionvehicules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkauto.gestionvehicules.entity.Vehicule;
import com.parkauto.gestionvehicules.services.VehiculeService;


@RestController
@RequestMapping("/vehicules")
@CrossOrigin("*")
public class VehiculeController {
    @Autowired
    VehiculeService vehiculeService;
    
    @PostMapping
    public Vehicule createVehicule(@Validated @RequestBody(required = false) Vehicule vehicule) {
        
        return vehiculeService.saveVehicule(vehicule);
        
    }
    
    @GetMapping("/list")
    public List<Vehicule> getAllVehicules(@Validated @RequestBody(required = false) Vehicule vehicule){
        return vehiculeService.getVehicules();
        
    }
    @GetMapping("/list/{idVehicule}")
    public ResponseEntity<Vehicule> findVehiculeById(@PathVariable(name="idVehicule") Long idVehicule) {
        if(idVehicule == null) {
            return ResponseEntity.notFound().build();                   
            
        }       
        Vehicule voit = vehiculeService.getVehiculeById(idVehicule);
        if(voit == null) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok().body(voit);
        
    }
    @DeleteMapping("/list/{id}")
    public ResponseEntity<Vehicule> deleteVehicule(@PathVariable(name="id") Long idVehicule){       
        
        Vehicule voit = vehiculeService.getVehiculeById(idVehicule);
        if(voit == null) {
            return ResponseEntity.notFound().build();           
        }
        vehiculeService.deleteVehicule(voit);
        return ResponseEntity.ok().body(voit);
    }

}

