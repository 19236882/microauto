package com.parkauto.gestionlocations.dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "vehicule-service", url = "http://localhost:8082/vehicules/list")
public interface VehiculeFeignClient {
   @GetMapping("/{id}")
   ResponseEntity<VehiculeDTO> getVehiculeById(@PathVariable("id") Long id);
}