package com.fx.master_reference.service;

import com.fx.master_reference.model.Region;
import com.fx.master_reference.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegionService {
    private final RegionRepository repository;

    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }

    public List<Region> getAll() {
        return repository.findAll();
    }

    public Optional<Region> getById(UUID id) {
        return repository.findById(id);
    }

    public Region create(Region region) {
        return repository.save(region);
    }

    public Region update(UUID id, Region region) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setRegionName(region.getRegionName());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Region not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
