package com.college.csms.service;

import com.college.csms.entity.Fee;
import com.college.csms.repository.FeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public Fee save(Fee fee) {
        return feeRepository.save(fee);
    }

    public List<Fee> getAll() {
        return feeRepository.findAll();
    }

    public Fee getByStudentId(Long studentId) {
        return feeRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Fee record not found"));
    }

    public void delete(Long id) {
        feeRepository.deleteById(id);
    }
}
