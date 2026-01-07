package com.fx.master_reference.service;


import com.fx.master_reference.model.EventType;
import com.fx.master_reference.model.ProximityType;
import com.fx.master_reference.repository.EventTypeRepository;
import com.fx.master_reference.repository.ProximityTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProximityTypeService {
    private final ProximityTypeRepository repository;

    public ProximityTypeService(ProximityTypeRepository repository) {
        this.repository = repository;
    }
    public List<ProximityType> getAll() {
        return repository.findAll();
    }

    public Optional<ProximityType> getById(UUID id) {
        return repository.findById(id);
    }

    public ProximityType create(ProximityType proximityType) {
        return repository.save(proximityType);
    }

    public ProximityType update(UUID id, ProximityType proximityType) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setProximityType(proximityType.getProximityType());
                    existing.setKeyFactors(proximityType.getKeyFactors());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("ProximityType not found with ID: " + id));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

