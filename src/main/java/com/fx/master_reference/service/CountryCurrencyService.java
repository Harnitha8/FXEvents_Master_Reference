package com.fx.master_reference.service;

import com.fx.master_reference.model.CountryCurrency;
import com.fx.master_reference.repository.CountryCurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryCurrencyService {
    private final CountryCurrencyRepository repository;

    public CountryCurrencyService(CountryCurrencyRepository repository) {
        this.repository = repository;
    }

    public List<CountryCurrency> getAll() {
        return repository.findAll();
    }
    public Optional<CountryCurrency> getById(UUID uuid) {
        return repository.findById(uuid);
    }

    public CountryCurrency create(CountryCurrency currency) {
        return repository.save(currency);
    }

    public CountryCurrency update(UUID id, CountryCurrency currency) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setCurrencyCode(currency.getCurrencyCode());
                    existing.setCurrencyName(currency.getCurrencyName());
                    existing.setCurrencySymbol(currency.getCurrencySymbol());
                    existing.setIsCurrencyActive(currency.getIsCurrencyActive());
                    existing.setCountryCode(currency.getCountryCode());
                    existing.setCountryName(currency.getCountryName());
                    existing.setRegion(currency.getRegion());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("CountryCurrency not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }


}
