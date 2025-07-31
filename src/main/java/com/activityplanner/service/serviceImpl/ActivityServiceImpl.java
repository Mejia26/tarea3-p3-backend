package com.activityplanner.service.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.activityplanner.dto.ActivityDTO;
import com.activityplanner.mapper.ActivityMapper;
import com.activityplanner.model.Activity;
import com.activityplanner.repository.ActivityRepository;
import com.activityplanner.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final ActivityRepository activityRepo;
	
	private static Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    public ActivityServiceImpl(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    @Override
    public List<ActivityDTO> findAll() {
    	logger.info("Retrieving activites");
        return activityRepo.findAll().stream()
                .map(ActivityMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDTO create(ActivityDTO dto) {
    	logger.info("Creating activites");
        Activity saved = activityRepo.save(ActivityMapper.toEntity(dto));
        return ActivityMapper.toDTO(saved);
    }

    @Override
    public ActivityDTO update(UUID id, ActivityDTO dto) {
    	logger.info("Updating activites");
        Activity existing = activityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        existing.setName(dto.getName());
        existing.setIcon(dto.getIcon());
        existing.setColor(dto.getColor());

        return ActivityMapper.toDTO(activityRepo.save(existing));
    }

    @Override
    public void delete(UUID id) {
    	logger.info("Deleting activites");
        activityRepo.deleteById(id);
    }
    
    private String addingTesting() {
    	logger.info("Testing activites");
    	return "testing";
    }
}
