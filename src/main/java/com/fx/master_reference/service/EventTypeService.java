package com.fx.master_reference.service;

import com.fx.master_reference.model.EventType;
import com.fx.master_reference.repository.EventTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventTypeService {
    private final EventTypeRepository repository;

    public EventTypeService(EventTypeRepository repository) {
        this.repository = repository;
    }

    public List<EventType> getAll() {
        return repository.findAll();
    }

    public Optional<EventType> getById(UUID id) {
        return repository.findById(id);
    }

    public EventType create(EventType eventType) {
        return repository.save(eventType);
    }

    public EventType update(UUID id, EventType eventType) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setEventTypeName(eventType.getEventTypeName());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("EventType not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
