package com.example.demo.service;
import com.example.demo.entity.Book;
import com.example.demo.projection.BookAuthorView;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo){this.repo=repo;}
    public List<Book> findAll(){return repo.findAll();}
    public Book save(Book b){return repo.save(b);}
    public Optional<Book> findById(Long id){return repo.findById(id);}
    public List<BookAuthorView> fetchBooksWithAuthors(){return repo.fetchBooksWithAuthors();}
    public boolean isbnExists(String isbn){return repo.existsByIsbn(isbn);}
}