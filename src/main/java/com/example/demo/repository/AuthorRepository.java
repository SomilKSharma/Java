package com.example.demo.repository;
import com.example.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface AuthorRepository extends JpaRepository<Author,Long>{
    Optional<Author> findByEmail(String email);
}