package com.activityplanner.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	
	@NotNull(message="name cannot be null")
    private String name;
    private String icon;
    private String color;
    
    @Size(min=5, message="description must be greater than 5")
    private String description;
    
    private String secondColor;
    private LocalDateTime createdAt;
    private String homeLinkBtn;
    private LocalDateTime selectedHour;
}
