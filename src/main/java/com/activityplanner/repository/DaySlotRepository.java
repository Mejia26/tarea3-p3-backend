package com.activityplanner.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activityplanner.model.DaySlot;

public interface DaySlotRepository extends JpaRepository<DaySlot,UUID> {

	List<DaySlot> findByDate(LocalDate date);
}
