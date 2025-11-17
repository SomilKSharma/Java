package com.example.demo.controller;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    public BookController(BookService bookService,AuthorService authorService){
        this.bookService=bookService;this.authorService=authorService;
    }
    @GetMapping
    public String listBooks(Model model){
        model.addAttribute("books",bookService.findAll());
        model.addAttribute("bookAuthorList",bookService.fetchBooksWithAuthors());
        return "listBooks";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("authors",authorService.findAll());
        return "bookForm";
    }
    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") Book book, BindingResult br, Model model,
                             RedirectAttributes ra, @RequestParam Long authorId){
        if(br.hasErrors()){
            model.addAttribute("authors",authorService.findAll());
            return "bookForm";
        }
        Author author=authorService.findById(authorId).orElseThrow();
        book.setAuthor(author);
        if(bookService.isbnExists(book.getIsbn())){
            ra.addFlashAttribute("error","ISBN exists");
            return "redirect:/books/create";
        }
        bookService.save(book);
        ra.addFlashAttribute("success","Book created");
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model){
        Book b=bookService.findById(id).orElseThrow();
        model.addAttribute("book",b);
        model.addAttribute("authors",authorService.findAll());
        return "bookEdit";
    }
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id,@ModelAttribute Book book,RedirectAttributes ra,@RequestParam Long authorId){
        Book existing=bookService.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
        existing.setAuthor(authorService.findById(authorId).orElseThrow());
        bookService.save(existing);
        ra.addFlashAttribute("success","Book updated");
        return "redirect:/books";
    }
}