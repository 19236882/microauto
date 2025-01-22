package com.parkauto.gestionlocations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parkauto.gestionlocations.entity.Location;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {


  
}
