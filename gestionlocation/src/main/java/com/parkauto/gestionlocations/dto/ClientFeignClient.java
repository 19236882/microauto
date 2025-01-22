package com.parkauto.gestionlocations.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "http://localhost:8081/clients")
public interface ClientFeignClient {
    @GetMapping("/{id}")
    ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id);
}