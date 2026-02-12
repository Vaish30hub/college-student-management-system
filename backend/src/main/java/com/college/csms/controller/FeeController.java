package com.college.csms.controller;

import com.college.csms.entity.Fee;
import com.college.csms.service.FeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@CrossOrigin
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @GetMapping
    public List<Fee> getAllFees() {
        return feeService.getAll();
    }

    @GetMapping("/{studentId}")
    public Fee getFeeByStudent(@PathVariable Long studentId) {
        return feeService.getByStudentId(studentId);
    }

    @PostMapping
    public Fee addFee(@RequestBody Fee fee) {
        return feeService.save(fee);
    }

    @DeleteMapping("/{id}")
    public void deleteFee(@PathVariable Long id) {
        feeService.delete(id);
    }
}
