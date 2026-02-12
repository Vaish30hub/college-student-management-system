package com.college.csms.service;

import com.college.csms.entity.Marks;
import com.college.csms.repository.MarksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {

    private final MarksRepository marksRepository;

    public MarksService(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    public Marks save(Marks marks) {
        return marksRepository.save(marks);
    }

    public List<Marks> getAll() {
        return marksRepository.findAll();
    }

    public List<Marks> getByStudentId(Long studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    public void delete(Long id) {
        marksRepository.deleteById(id);
    }
}
