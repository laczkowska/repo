package com.example.library.resource;

import com.example.library.data.*;
import com.example.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/loan")
    @ResponseStatus(HttpStatus.CREATED)
    public void loanBook(@RequestParam Long bookId, @RequestParam Long customerId) {
        libraryService.loanBook(bookId, customerId);
    }

    @GetMapping("/available-books")
    public List<Book> getAvailableBooks() {
        return libraryService.getAvailableBooks();
    }

    // Add more endpoints for managing books, authors, customers, and loans
    // ...
}