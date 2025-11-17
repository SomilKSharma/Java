package com.example.demo.repository;
import com.example.demo.entity.Book;
import com.example.demo.projection.BookAuthorView;
import org.springframework.data.jpa.repository.*;
import java.util.*;
public interface BookRepository extends JpaRepository<Book,Long>{
    @Query("SELECT b.id as bookId,b.title as title,b.isbn as isbn,a.id as authorId,a.name as authorName FROM Book b JOIN b.author a")
    List<BookAuthorView> fetchBooksWithAuthors();
    boolean existsByIsbn(String isbn);
}