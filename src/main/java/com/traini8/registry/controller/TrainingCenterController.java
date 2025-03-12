package com.traini8.registry.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traini8.registry.dto.TrainingCenterRequest;
import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenterRequest request) {
        TrainingCenter saved = service.createTrainingCenter(request);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        return ResponseEntity.ok(service.getAllTrainingCenters());
    }
}