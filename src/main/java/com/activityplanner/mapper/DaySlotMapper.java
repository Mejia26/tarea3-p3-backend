package com.activityplanner.mapper;

import com.activityplanner.dto.DaySlotDTO;
import com.activityplanner.model.Activity;
import com.activityplanner.model.DaySlot;

import java.time.LocalDate;

public class DaySlotMapper {

    public static DaySlot toEntity(DaySlotDTO dto, Activity activity) {
        return DaySlot.builder()
                .id(dto.getId())
                .date(LocalDate.parse(dto.getDate()))
                .hour(dto.getHour())
                .activity(activity)
                .build();
    }

    public static DaySlotDTO toDTO(DaySlot entity) {
        return DaySlotDTO.builder()
                .id(entity.getId())
                .date(entity.getDate().toString())
                .hour(entity.getHour())
                .activityId(entity.getActivity().getId())
                .build();
    }
}