package com.activityplanner.service;

import java.util.List;
import java.util.UUID;

import com.activityplanner.dto.DaySlotDTO;

public interface DaySlotService {

	List<DaySlotDTO> getAllByDate(String date);
    DaySlotDTO create(DaySlotDTO dto);
    void delete(UUID id);
}
