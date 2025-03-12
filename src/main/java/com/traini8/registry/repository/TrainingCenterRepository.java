package com.traini8.registry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traini8.registry.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}