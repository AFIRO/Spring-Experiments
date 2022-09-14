package com.zetta.springexperiments.repository;

import com.zetta.springexperiments.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends
        JpaRepository<Aircraft, String> {
}
