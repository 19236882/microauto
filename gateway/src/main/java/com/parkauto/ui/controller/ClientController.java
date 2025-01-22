package com.parkauto.ui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.parkauto.ui.dto.ClientDTO;

@Controller
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    private final String CLIENT_API_URL = "http://localhost:8080/api/clients"; // API Gateway URL

    @GetMapping("/client-form")
    public String showClientForm(Model model) {
        model.addAttribute("client", new ClientDTO());
        return "client-form";
    }

    @PostMapping("/clients")
    public String saveClient(@ModelAttribute("client") ClientDTO client, Model model) {
       restTemplate.postForObject(CLIENT_API_URL+"/register", client, ClientDTO.class);
        model.addAttribute("message", "Client enregistré avec succès !");
        return "confirmation";
    }
}
