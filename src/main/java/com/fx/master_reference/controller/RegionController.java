package com.fx.master_reference.controller;

import com.fx.master_reference.model.Region;
import com.fx.master_reference.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/master_reference/regions")
public class RegionController {

    private final RegionService service;

    public RegionController(RegionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Region> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getById(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Region create(@RequestBody Region region) {
        return service.create(region);
    }

    @PutMapping("/{id}")
    public Region update(@PathVariable UUID id, @RequestBody Region region) {
        return service.update(id, region);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
