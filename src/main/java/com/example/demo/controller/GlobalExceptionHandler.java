package com.example.demo.controller;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleIntegrity(DataIntegrityViolationException ex, RedirectAttributes ra){
        ra.addFlashAttribute("error","Integrity error");
        return "redirect:/books";
    }
    @ExceptionHandler(Exception.class)
    public String handleAll(Exception ex, RedirectAttributes ra){
        ra.addFlashAttribute("error","Unexpected error");
        return "redirect:/books";
    }
}