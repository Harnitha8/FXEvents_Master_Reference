package com.fx.master_reference.controller;

import com.fx.master_reference.model.CountryCurrency;
import com.fx.master_reference.service.CountryCurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/master_reference/country-currency")
public class CountryCurrencyController {
    private final CountryCurrencyService service;

    public CountryCurrencyController(CountryCurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<CountryCurrency> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryCurrency> getById(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CountryCurrency create(@RequestBody CountryCurrency currency) {
        return service.create(currency);
    }

    @PutMapping("/{id}")
    public CountryCurrency update(@PathVariable UUID id, @RequestBody CountryCurrency currency) {
        return service.update(id, currency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
