package com.fx.master_reference.repository;

import com.fx.master_reference.model.ProximityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProximityTypeRepository extends JpaRepository<ProximityType, UUID> {
}
