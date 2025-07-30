package com.activityplanner.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDTO {

	private UUID id;
    private String name;
    private String icon;
    private String color;
    private String description;
    private String secondColor;
    private LocalDateTime createdAt;
    private String homeLinkBtn;
}
