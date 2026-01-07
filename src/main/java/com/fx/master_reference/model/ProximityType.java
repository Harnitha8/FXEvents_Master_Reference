package com.fx.master_reference.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "PROXIMITY_TYPES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProximityType {
    @Id
    @GeneratedValue
    @Column(name = "PROXIMITY_TYPE_ID", updatable = false, nullable = false)
    private UUID proximityTypeId;

    @Column(name = "PROXIMITY_TYPE", nullable = false)
    private String proximityType;

    @Column(name = "KEY_FACTORS", columnDefinition = "varchar(MAX)")
    private String keyFactors;
}
