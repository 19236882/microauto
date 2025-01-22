package com.parkauto.ui.dto;

import lombok.*;

@Data // Génère automatiquement les getters, setters, equals, hashCode et toString
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Builder // Permet de construire des objets en utilisant un pattern Builder
public class ClientDTO {

    private Long idClient;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
}
