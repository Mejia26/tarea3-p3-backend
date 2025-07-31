package com.activityplanner.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activityplanner.dto.ActivityDTO;
import com.activityplanner.model.Activity;
import com.activityplanner.repository.ActivityRepository;
import com.activityplanner.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
	
	private static Logger logger = LoggerFactory.getLogger(ActivityController.class);

	private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityDTO> getAll() {
    	logger.info("retrieving all activities");
        return service.findAll();
    }

    @PostMapping
    public ActivityDTO create(@RequestBody ActivityDTO dto) {
    	logger.info("Creating activy");
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ActivityDTO update(@PathVariable UUID id, @RequestBody ActivityDTO dto) {
    	logger.info("Updating activity");
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable UUID id) {
    	logger.warn("Deleting activity");
        service.delete(id);
        
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(
        				Map.of("message","Activity successfully deleted!")
        				);
    }
}
