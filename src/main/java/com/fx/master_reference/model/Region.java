package com.fx.master_reference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "REGIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue
    @Column(name = "REGION_ID", updatable = false, nullable = false)
    private UUID regionId;

    @Column(name = "REGION_NAME", nullable = false)
    private String regionName;
}
