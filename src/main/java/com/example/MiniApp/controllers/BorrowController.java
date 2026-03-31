package com.example.MiniApp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.MiniApp.exceptions.BookAlreadyBorrwoedException;
import com.example.MiniApp.models.Book;
import com.example.MiniApp.models.BrowBook;
import com.example.MiniApp.models.ErrorDetails;
import com.example.MiniApp.services.BooksServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class BorrowController {
    private BooksServices booksServices;
    public BorrowController( BooksServices booksServices){
        this.booksServices=booksServices;
    }
    @PostMapping("/borrow/{id}")
    public ResponseEntity<?> postMethodName(@PathVariable int id) {
        List<Book> lb=new ArrayList<>();
        try{
            lb=booksServices.postBrowBook(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(lb);

        }catch(BookAlreadyBorrwoedException e){
            ErrorDetails er= new ErrorDetails();
            er.setErrormessage("THAT BOOK IS ALEARDY BORRWED");
            return ResponseEntity.badRequest().body(er);

        }
        
        
    }
    
}
