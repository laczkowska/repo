package com.example.library.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

public class StarRating {
    private int ratingId;
    private int stars;
    private Book associatedBook;

    // Konstruktory, gettery i settery

    public StarRating(int ratingId, int stars, Book associatedBook) {
        this.ratingId = ratingId;
        this.stars = stars;
        this.associatedBook = associatedBook;
    }

    // Dodatkowe metody, jeśli są potrzebne
}

public class Book {
    private int bookId;
    private String title;
    private String author;
    // Dodatkowe informacje o książce

    // Konstruktory, gettery i settery

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Dodatkowe metody, jeśli są potrzebne
}
