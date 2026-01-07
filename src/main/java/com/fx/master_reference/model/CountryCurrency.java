package com.fx.master_reference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUNTRY_CURRENCY")
public class CountryCurrency {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id; // rename from uuid to id for clarity

    @Column(name = "COUNTRY_CODE", nullable = false, length = 2, columnDefinition = "CHAR(2)")
    private String countryCode;

    @Column(name = "COUNTRY_NAME", nullable = false, length = 50)
    private String countryName;

    @Column(name = "CURRENCY_CODE", nullable = false, length = 3, columnDefinition = "CHAR(3)")
    private String currencyCode;

    @Column(name = "CURRENCY_NAME", nullable = false, length = 50)
    private String currencyName;

    @Column(name = "CURRENCY_SYMBOL", length = 5, columnDefinition = "CHAR(1)")
    private String currencySymbol;

    @Column(name = "IS_CURRENCY_ACTIVE", nullable = false)
    private Boolean isCurrencyActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID", nullable = false)
    private Region region;
}
