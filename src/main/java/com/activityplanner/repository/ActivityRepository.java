package com.activityplanner.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activityplanner.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, UUID>{

}
