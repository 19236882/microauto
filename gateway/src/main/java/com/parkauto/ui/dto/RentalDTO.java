package com.parkauto.ui.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateRetour;
    private Long clientId;
    private Long vehicleId;
}

