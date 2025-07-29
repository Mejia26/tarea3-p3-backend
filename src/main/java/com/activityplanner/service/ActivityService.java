package com.activityplanner.service;

import java.util.List;
import java.util.UUID;

import com.activityplanner.dto.ActivityDTO;

public interface ActivityService {

	List<ActivityDTO> findAll();
    ActivityDTO create(ActivityDTO dto);
    ActivityDTO update(UUID id, ActivityDTO dto);
    void delete(UUID id);
}
