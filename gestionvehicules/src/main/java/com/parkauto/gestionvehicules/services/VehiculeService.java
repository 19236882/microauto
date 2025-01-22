package com.parkauto.gestionvehicules.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.gestionvehicules.entity.Vehicule;
import com.parkauto.gestionvehicules.repository.IVehiculeRepository;


@Service
public class VehiculeService {

    @Autowired
    IVehiculeRepository vehiculeRepository;
    
    //Liste des véhicules
    public List<Vehicule> getVehicules(){
        return vehiculeRepository.findAll();
        
    }
    
    //Save
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
        
    }
    
    //Get a vehicule
    public Vehicule getVehiculeById(Long idvehi) {
        return vehiculeRepository.findById(idvehi).get();
        
    }
    
    //Delete a vehicule
    public void deleteVehicule(Vehicule vehicule) {
        vehiculeRepository.delete(vehicule);
    }
    
}

