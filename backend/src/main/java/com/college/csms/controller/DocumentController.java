package com.college.csms.controller;

import com.college.csms.entity.Document;
import com.college.csms.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAll();
    }

    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentService.save(document);
    }
}
