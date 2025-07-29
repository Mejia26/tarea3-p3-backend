package com.activityplanner.controller;

import com.activityplanner.dto.DaySlotDTO;
import com.activityplanner.service.DaySlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dayslots")
@CrossOrigin(origins = "*")
public class DaySlotController {

    private final DaySlotService service;

    public DaySlotController(DaySlotService service) {
        this.service = service;
    }

    @GetMapping
    public List<DaySlotDTO> getByDate(@RequestParam String date) {
        return service.getAllByDate(date);
    }

    @PostMapping
    public DaySlotDTO create(@RequestBody DaySlotDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}