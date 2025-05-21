package com.marius.controllers;

import com.marius.model.Document;
import com.marius.services.DocumentService;
import com.marius.utils.ItemRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/document")
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/hi")
    public String hiMessage() {
        return "Hello";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<Document> getDocumentById(@PathVariable("documentId") int documentId) {
        return ResponseEntity.ok(documentService.getDocumentById(documentId));
    }

    @PostMapping("/add")
    public ResponseEntity<Document> addDocument(@RequestBody ItemRequest request) {
        log.info("Document: {}", request);
        return ResponseEntity.ok(documentService.addDocument(request));
    }

    @DeleteMapping("/{documentId}")
    public void deleteDocumentById(@PathVariable("documentId") int documentId) {
        documentService.removeDocumentById(documentId);
    }

}
