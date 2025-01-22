package com.parkauto.ui.dto;

import lombok.*;

@Data // Génère automatiquement les getters, setters, equals, hashCode et toString
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Builder // Permet de construire des objets en utilisant un pattern Builder
public class VehiculeDTO {
    private Long idvehicule;  // Correspond à `idvehicule` dans l'entité
    private Integer anneeModel;
    private Double prix;
    private String imageVehicule;
}
