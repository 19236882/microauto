package com.parkauto.ui.controller;

import com.parkauto.ui.dto.ClientDTO;
import com.parkauto.ui.dto.LocationDTO;
import com.parkauto.ui.dto.VehiculeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;        // Pour Arrays.stream()
import java.util.List;          // Pour List
import java.util.stream.Collectors; // Pour Collectors.toList()

@Controller
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);


    @Autowired
    private RestTemplate restTemplate;

    private final String LOCATION_API_URL = "http://localhost:8080/api/locations"; // API Gateway URL

    /**
     * Affiche le formulaire pour créer une nouvelle location.
     */
    // @GetMapping("/location-form")
    // public String showLocationForm(Model model) {
    //     model.addAttribute("location", new LocationDTO());
    //     return "location-form"; // Page Thymeleaf "location-form.html"
    // }

    /**
     * Reçoit les données du formulaire et les transmet au microservice via l'API Gateway.
     */
    @PostMapping("/locations")
    public String createLocation(@ModelAttribute("location") LocationDTO locationDTO, Model model) {
        try {
            restTemplate.postForObject(LOCATION_API_URL, locationDTO, LocationDTO.class);
            model.addAttribute("message", "La location a été créée avec succès !");
        } catch (Exception e) {
            model.addAttribute("error", "Une erreur s'est produite : " + e.getMessage());
        }
        return "confirmation1"; // Page de confirmation (similaire à celle des clients)
    }

    @GetMapping("/location-form")
    public String showLocationForm(Model model) {
        // Récupérer les clients depuis l'API Gateway
        String clientsUrl = "http://localhost:8080/api/clients";
        ClientDTO[] clients = restTemplate.getForObject(clientsUrl, ClientDTO[].class);
    
        // Récupérer les véhicules depuis l'API Gateway
        String vehiculesUrl = "http://localhost:8080/api/vehicules/list";
        VehiculeDTO[] vehicules = restTemplate.getForObject(vehiculesUrl, VehiculeDTO[].class);
    
        // Loggez le contenu des véhicules
        if (vehicules != null) {
            logger.info("Contenu des véhicules récupérés depuis l'API Gateway :");
            for (VehiculeDTO vehicule : vehicules) {
                logger.info(vehicule.toString());
            }
        } else {
            logger.warn("Aucun véhicule récupéré depuis l'API Gateway.");
        }
    
        // Ajouter les véhicules et les clients au modèle
        model.addAttribute("vehicules", vehicules);
        model.addAttribute("clients", clients);
        model.addAttribute("location", new LocationDTO());
    
        return "location-form"; // Vue Thymeleaf
    }
    




}
