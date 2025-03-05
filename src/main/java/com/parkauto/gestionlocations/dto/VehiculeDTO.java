package com.parkauto.gestionlocations.dto;

public class VehiculeDTO {
    private Long idVehicule;
    private Integer anneeModel;
    private Double prix;
    private String imageVehicule;

    // Constructeurs
    public VehiculeDTO() {
    }

    public VehiculeDTO(Long idVehicule, Integer anneeModel, Double prix, String imageVehicule) {
        this.idVehicule = idVehicule;
        this.anneeModel = anneeModel;
        this.prix = prix;
        this.imageVehicule = imageVehicule;
    }

    // Getters et Setters
    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Integer getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(Integer anneeModel) {
        this.anneeModel = anneeModel;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getImageVehicule() {
        return imageVehicule;
    }

    public void setImageVehicule(String imageVehicule) {
        this.imageVehicule = imageVehicule;
    }
}
