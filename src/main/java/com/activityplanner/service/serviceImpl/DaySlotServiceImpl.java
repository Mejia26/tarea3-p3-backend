package com.activityplanner.service.serviceImpl;

import com.activityplanner.dto.DaySlotDTO;
import com.activityplanner.mapper.DaySlotMapper;
import com.activityplanner.model.Activity;
import com.activityplanner.model.DaySlot;
import com.activityplanner.repository.ActivityRepository;
import com.activityplanner.repository.DaySlotRepository;
import com.activityplanner.service.DaySlotService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DaySlotServiceImpl implements DaySlotService {

    private final DaySlotRepository daySlotRepo;
    private final ActivityRepository activityRepo;

    public DaySlotServiceImpl(DaySlotRepository daySlotRepo, ActivityRepository activityRepo) {
        this.daySlotRepo = daySlotRepo;
        this.activityRepo = activityRepo;
    }

    @Override
    public List<DaySlotDTO> getAllByDate(String date) {
        return daySlotRepo.findByDate(LocalDate.parse(date)).stream()
                .map(DaySlotMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DaySlotDTO create(DaySlotDTO dto) {
        Activity activity = activityRepo.findById(dto.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        DaySlot saved = daySlotRepo.save(DaySlotMapper.toEntity(dto, activity));
        return DaySlotMapper.toDTO(saved);
    }

    @Override
    public void delete(UUID id) {
        daySlotRepo.deleteById(id);
    }
}