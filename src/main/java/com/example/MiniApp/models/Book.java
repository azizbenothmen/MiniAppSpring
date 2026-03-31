package com.example.MiniApp.models;

import lombok.Data;

@Data
public class Book {
    private int id ;
    private String title;
    private String author; 
    
    public Book(int id,String t,String author){
        this.id=id;
        title=t;
        this.author=author;
    }
}
