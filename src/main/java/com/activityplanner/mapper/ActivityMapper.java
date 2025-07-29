package com.activityplanner.mapper;

import com.activityplanner.dto.ActivityDTO;
import com.activityplanner.model.Activity;

public class ActivityMapper {

	public static ActivityDTO toDTO(Activity entity) {
        return ActivityDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .icon(entity.getIcon())
                .color(entity.getColor())
                .build();
    }

    public static Activity toEntity(ActivityDTO dto) {
        return Activity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .icon(dto.getIcon())
                .color(dto.getColor())
                .build();
    }
}
