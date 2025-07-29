package com.activityplanner.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "day_slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DaySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate date;

    private String hour;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
}