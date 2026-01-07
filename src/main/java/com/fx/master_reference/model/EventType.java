package com.fx.master_reference.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENT_TYPE")
public class EventType {
    @Id
    @GeneratedValue
    @Column(name = "EVENT_TYPE_ID")
    private UUID eventTypeId;

    @Column(name = "EVENT_TYPE_NAME", nullable = false)
    private String eventTypeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROXIMITY_TYPE_ID", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProximityType proximityTypeId;
}
