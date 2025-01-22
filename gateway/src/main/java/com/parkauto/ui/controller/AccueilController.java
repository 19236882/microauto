package com.parkauto.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @GetMapping("/accueil")
    public String showAccueil(Model model) {
        return "accueil"; // Le nom de la vue Thymeleaf pour la page d'accueil
    }
}
