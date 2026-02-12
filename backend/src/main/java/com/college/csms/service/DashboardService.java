package com.college.csms.service;

import com.college.csms.repository.FeeRepository;
import com.college.csms.repository.MarksRepository;
import com.college.csms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final StudentRepository studentRepository;
    private final FeeRepository feeRepository;
    private final MarksRepository marksRepository;

    public DashboardService(StudentRepository studentRepository,
                            FeeRepository feeRepository,
                            MarksRepository marksRepository) {
        this.studentRepository = studentRepository;
        this.feeRepository = feeRepository;
        this.marksRepository = marksRepository;
    }

    public Map<String, Object> getSummary() {

        Map<String, Object> data = new HashMap<>();

        data.put("totalStudents", studentRepository.count());

        BigDecimal totalCollected = feeRepository.findAll()
                .stream()
                .map(f -> f.getPaidAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPending = feeRepository.findAll()
                .stream()
                .map(f -> f.getDueAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        data.put("totalFeesCollected", totalCollected);
        data.put("totalFeesPending", totalPending);

        data.put("totalMarksEntries", marksRepository.count());

        return data;
    }
}
