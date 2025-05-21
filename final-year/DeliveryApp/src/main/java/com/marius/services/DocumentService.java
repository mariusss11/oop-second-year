package com.marius.services;

import com.marius.model.Document;
import com.marius.model.Load;
import com.marius.repositories.DocumentRepository;
import com.marius.repositories.DocumentRepository;
import com.marius.repositories.LoadRepository;
import com.marius.utils.ItemRequest;
import com.marius.utils.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final LoadService loadService;

    public Document getDocumentById(int documentId) {
        return documentRepository.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found"));
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document addDocument(ItemRequest request) {
        Load load = loadService.getLoadById(request.getLoadId());

        return documentRepository.save(Document.builder()
                        .details(request.getDetails())
                        .load(load)
                .build());
    }

    public void removeDocumentById(int documentId) {
        documentRepository.deleteById(documentId);
    }

}
