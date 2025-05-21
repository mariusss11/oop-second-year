package com.marius.controllers;


import com.marius.model.Cargo;
import com.marius.services.CargoService;
import com.marius.utils.ItemRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cargo")
public class CargoController {


    private final CargoService cargoService;

    @GetMapping("/hi")
    public String hiMessage() {
        return "Hello";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cargo>> getAllCargos() {
        return ResponseEntity.ok(cargoService.getAllCargos());
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable("documentId") int documentId) {
        return ResponseEntity.ok(cargoService.getCargoById(documentId));
    }

    @PostMapping("/add")
    public ResponseEntity<Cargo> addCargo(@RequestBody ItemRequest request) {
        log.info("Cargo: {}", request);
        return ResponseEntity.ok(cargoService.addCargo(request));
    }

    @DeleteMapping("/{documentId}")
    public void deleteCargoById(@PathVariable("documentId") int documentId) {
        cargoService.removeCargoById(documentId);
    }

}
