package com.parkauto.gestionlocations.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOCATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDLOCATION")
    private Long id;

    @Column(name = "DATELOCATION")
    private LocalDate dateLocation;

    @Column(name = "DATEDEBUT")
    private LocalDate dateDebut;

    @Column(name = "DATERETOUR")
    private LocalDate dateRetour;

    @Column(name = "CLIENTID")
    private Long client; // Stocke les IDs des clients associés

    @Column(name = "VEHICULEID")
    private Long vehicule;

}

