package com.traini8.registry.service;

import com.traini8.registry.dto.TrainingCenterRequest;
import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainingCenterService {
    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public TrainingCenter createTrainingCenter(TrainingCenterRequest request) {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName(request.getCenterName());
        trainingCenter.setCenterCode(request.getCenterCode());
        trainingCenter.setAddress(request.getAddress());
        trainingCenter.setStudentCapacity(request.getStudentCapacity());
        trainingCenter.setCoursesOffered(request.getCoursesOffered() != null ? request.getCoursesOffered() : List.of());
        trainingCenter.setContactEmail(request.getContactEmail());
        trainingCenter.setContactPhone(request.getContactPhone());
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
}