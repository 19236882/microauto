package com.parkauto.gestionlocations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkauto.gestionlocations.dto.ClientDTO;
import com.parkauto.gestionlocations.dto.ClientFeignClient;
import com.parkauto.gestionlocations.dto.VehiculeDTO;
import com.parkauto.gestionlocations.dto.VehiculeFeignClient;
import com.parkauto.gestionlocations.entity.Location;
import com.parkauto.gestionlocations.repository.ILocationRepository;


import java.util.List;

@Service
public class LocationService {

    @Autowired
    private ILocationRepository locationRepository;

    @Autowired
    private ClientFeignClient clientFeignClient;

    @Autowired
    private VehiculeFeignClient vehiculeFeignClient;

    public Location saveLocation(Location location) {
        // Vérifie si le client existe
        ClientDTO client = clientFeignClient.getClientById(location.getClient())
            .getBody();
        if (client == null) {
            throw new RuntimeException("Client with ID " + location.getClient() + " does not exist.");
        }

        // Vérifie si le véhicule existe
        VehiculeDTO vehicule = vehiculeFeignClient.getVehiculeById(location.getVehicule())
            .getBody();
        if (vehicule == null) {
            throw new RuntimeException("Vehicule with ID " + location.getVehicule() + " does not exist.");
        }

        // Si le client et le véhicule existent, sauvegarder la location
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        if (!locationRepository.existsById(id)) {
            throw new RuntimeException("Location with ID " + id + " does not exist.");
        }
        locationRepository.deleteById(id);
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Location with ID " + id + " not found."));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
