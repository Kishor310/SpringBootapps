package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book(123,"Java Reference","Kishor") );
        list.add(new Book(456,"Java workd","Kishor") );
    }
 //Get all books
    public List<Book> getAllBooks(){
        return list;
    }
//Get Single book
    public Book getBookById(int id){
        Book book=null;
        try{
        book=list.stream().filter(e -> e.getId()==id).findFirst().get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }
//Adding the book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

//Delete the book
    public void deleteBook(int bid){
        list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }

//Update the Book
    public void updateBook(Book book,int bookId){
        list=list.stream().map(b->{
            if(b.getId()== bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
