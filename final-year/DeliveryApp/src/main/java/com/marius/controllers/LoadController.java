package com.marius.controllers;

import com.marius.model.Load;
import com.marius.services.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/load")
public class LoadController {

    private final LoadService loadService;

    @GetMapping("/hi")
    public String hiMessage() {
        return "Hello";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Load>> getAllLoads() {
        return ResponseEntity.ok(loadService.getAllLoads());
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable("loadId") int loadId) {
        return ResponseEntity.ok(loadService.getLoadById(loadId));
    }

    @PostMapping("/add")
    public ResponseEntity<Load> addLoad(@RequestBody Load load) {
        return ResponseEntity.ok(loadService.addLoad(load));
    }

    @DeleteMapping("/{loadId}")
    public void deleteLoadById(@PathVariable("loadId") int loadId) {
        loadService.removeLoadById(loadId);
    }




}
