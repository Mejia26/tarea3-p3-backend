package com.activityplanner.service.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.activityplanner.dto.ActivityDTO;
import com.activityplanner.mapper.ActivityMapper;
import com.activityplanner.model.Activity;
import com.activityplanner.repository.ActivityRepository;
import com.activityplanner.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final ActivityRepository activityRepo;

    public ActivityServiceImpl(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    @Override
    public List<ActivityDTO> findAll() {
        return activityRepo.findAll().stream()
                .map(ActivityMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDTO create(ActivityDTO dto) {
        Activity saved = activityRepo.save(ActivityMapper.toEntity(dto));
        return ActivityMapper.toDTO(saved);
    }

    @Override
    public ActivityDTO update(UUID id, ActivityDTO dto) {
        Activity existing = activityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        existing.setName(dto.getName());
        existing.setIcon(dto.getIcon());
        existing.setColor(dto.getColor());

        return ActivityMapper.toDTO(activityRepo.save(existing));
    }

    @Override
    public void delete(UUID id) {
        activityRepo.deleteById(id);
    }
}
