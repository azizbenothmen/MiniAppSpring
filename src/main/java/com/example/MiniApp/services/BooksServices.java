package com.example.MiniApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MiniApp.exceptions.BookAlreadyBorrwoedException;
import com.example.MiniApp.models.Book;
import com.example.MiniApp.models.BrowBook;

@Service
public class BooksServices {
    private List<BrowBook> LBB;
    private List<Book> LAB;

    public List<Book> postBrowBook(@RequestParam int id){
        LAB=new ArrayList<>();
        LBB=new ArrayList<>();
        int idB;
        Book ba=new Book(125,"JAMES CLEAR","ATOMIC HABITS");
        Book bc=new Book(127,"JAMES CLEAR","ATOMIC HABITS");

        LAB.add(ba);
        LAB.add(bc);
        BrowBook BE=new BrowBook();
        for(Book B:LAB){
            idB=B.getId();
            if(idB==id){
                BE.setBorrowerName("AZIZ");
                BE.setIdBook(id);
                BE.setMessage("OKKK");
                LBB.add(BE);
                LAB.remove(B);
                return LAB;
            }
        }
        throw new BookAlreadyBorrwoedException();


    }
    
}
