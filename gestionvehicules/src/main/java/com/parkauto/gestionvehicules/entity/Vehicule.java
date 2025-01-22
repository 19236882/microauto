package com.parkauto.gestionvehicules.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VEHICULE")
@Data // Génère automatiquement les getters, setters, equals, hashCode et toString
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Builder // Permet de construire des objets en utilisant un pattern Builder
public class Vehicule {
    @Id
    @Column(name = "IDVEHICULE")
    private Long idvehicule;

    @Column(name = "ANNEEMODEL")
    private Integer anneeModel;

    @Column(name = "PRIX")
    private Double prix;

    @Column(name = "IMAGE_VEHICULE")
    private String imageVehicule;

}
