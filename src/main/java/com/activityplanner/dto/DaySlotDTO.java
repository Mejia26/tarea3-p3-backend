package com.activityplanner.dto;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DaySlotDTO {
    private UUID id;
    private String date; // ISO-8601 (ej. "2025-07-29")
    private String hour;
    private UUID activityId;
}
