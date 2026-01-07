package com.fx.master_reference.controller;

import com.fx.master_reference.model.ProximityType;
import com.fx.master_reference.service.ProximityTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/master_reference/proximity-types")
public class ProximityTypeController {

    private final ProximityTypeService service;

    public ProximityTypeController(ProximityTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProximityType> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProximityType> getById(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProximityType create(@RequestBody ProximityType proximityType) {
        return service.create(proximityType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProximityType> update(@PathVariable UUID id, @RequestBody ProximityType proximityType) {
        try {
            ProximityType updated = service.update(id, proximityType);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}