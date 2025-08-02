package com.adhnan.booksWebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhnan.booksWebsite.model.PdfDocument;
import com.adhnan.booksWebsite.repository.PdfRepository;

@RestController
@RequestMapping("/api/pdfs")
@CrossOrigin
public class PdfController {

    @Autowired
    private PdfRepository pdfRepository;

    @GetMapping
    public List<PdfDocument> getAll() {
        return pdfRepository.findAll();
    }

    @PostMapping
    public PdfDocument create(@RequestBody PdfDocument doc) {
        return pdfRepository.save(doc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pdfRepository.deleteById(id);
    }
    
    @GetMapping("/{id}")
    public PdfDocument getOne(@PathVariable Long id) {
    	return pdfRepository.findById(id).orElse(null);
    }
    
    //search function
    @GetMapping("/search")
    public List<PdfDocument> searchBooks(@RequestParam("query") String query) {
        return pdfRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query);
    }
    
    
    @GetMapping("/featured")
    public List<PdfDocument> getFeaturedBooks() {
        List<Long> featuredIds = List.of(8L, 6L, 7L); // Replace with your featured book IDs
        return pdfRepository.findAllById(featuredIds);
    }
    
    
   
}
