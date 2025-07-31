package com.activityplanner.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ActivityDTO {

	private UUID id;
	
	@NotNull(message="name cannot be null")
    private String name;
    private String icon;
    private String color;
    private String description;
    private String secondColor;
    private LocalDateTime createdAt;
    private String homeLinkBtn;
    private LocalDateTime selectedHour;
}
