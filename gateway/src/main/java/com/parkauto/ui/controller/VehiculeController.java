package com.parkauto.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.parkauto.ui.dto.VehiculeDTO;

import java.util.Arrays;
import java.util.List;

@Controller
public class VehiculeController {

    private final RestTemplate restTemplate;
    private final String gatewayUrl;

    public VehiculeController(RestTemplate restTemplate, 
                              @Value("${gateway.url}") String gatewayUrl) {
        this.restTemplate = restTemplate;
        this.gatewayUrl = gatewayUrl;
    }

    @GetMapping("/vehicules")
    public String showVehicules(Model model) {
        // Appel à la Gateway via l'URL spécifique
        String url = gatewayUrl + "/api/vehicules/list"; // Exemple : http://localhost:8080/api/vehicules/list
        VehiculeDTO[] response = restTemplate.getForObject(url, VehiculeDTO[].class);

        // Conversion en liste
        List<VehiculeDTO> vehicules = Arrays.asList(response);

        model.addAttribute("vehicules", vehicules);
        return "vehicules"; // Le nom de la vue Thymeleaf
    }
}
