package com.activityplanner.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

	private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<ActivityDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ActivityDTO create(@RequestBody ActivityDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ActivityDTO update(@PathVariable UUID id, @RequestBody ActivityDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable UUID id) {
        service.delete(id);
        
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(
        				Map.of("message","Activity successfully deleted!")
        				);
    }
}
