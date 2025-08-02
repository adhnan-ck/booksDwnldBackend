package com.adhnan.booksWebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adhnan.booksWebsite.model.PdfDocument;

@Repository
public interface PdfRepository extends JpaRepository<PdfDocument, Long> {
	List<PdfDocument> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);
}