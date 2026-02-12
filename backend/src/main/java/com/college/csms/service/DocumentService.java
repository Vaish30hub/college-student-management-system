package com.college.csms.service;

import com.college.csms.entity.Document;
import com.college.csms.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public List<Document> getByStudentId(Long studentId) {
        return documentRepository.findByStudentId(studentId);
    }
}
