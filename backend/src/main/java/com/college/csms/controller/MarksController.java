package com.college.csms.controller;

import com.college.csms.entity.Marks;
import com.college.csms.service.MarksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin
public class MarksController {

    private final MarksService marksService;

    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    @GetMapping
    public List<Marks> getAllMarks() {
        return marksService.getAll();
    }

    @PostMapping
    public Marks addMarks(@RequestBody Marks marks) {
        return marksService.save(marks);
    }

    @DeleteMapping("/{id}")
    public void deleteMarks(@PathVariable Long id) {
        marksService.delete(id);
    }
}
