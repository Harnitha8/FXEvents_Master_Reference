package com.fx.master_reference.controller;

import com.fx.master_reference.model.EventType;
import com.fx.master_reference.service.EventTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/master_reference/event-types")
public class EventTypeController {

    private final EventTypeService service;

    public EventTypeController(EventTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventType> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventType> getById(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventType create(@RequestBody EventType eventType) {
        return service.create(eventType);
    }

    @PutMapping("/{id}")
    public EventType update(@PathVariable UUID id, @RequestBody EventType eventType) {
        return service.update(id, eventType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}