package com.parkauto.gestionvehicules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkauto.gestionvehicules.entity.Vehicule;

@Repository
public interface IVehiculeRepository extends JpaRepository<Vehicule, Long>{

}

