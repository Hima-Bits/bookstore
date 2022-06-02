package com.example.bookstore.Controller;

import com.example.bookstore.Model.*;
import com.example.bookstore.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BookStore")
public class BookController {
    private final String API_KEY="123";
    @Autowired
    private Repository reso;

    @PostMapping("/create")
    public Result create(@RequestBody UpdateModel updateModel) {
System.out.println(updateModel);
        if(updateModel.getKey()!=null && updateModel.getKey().equals(API_KEY))
            return reso.create(updateModel.getBook());
        else if(updateModel.getKey()==null)
            return reso.getResult("Failure "," API key is not sent");
        else {
            return reso.getResult("Failure "," API key is invalid");
        }

    }




    @GetMapping("/getAllBooks")
    public Result getAllBooks() {

        return reso.getAllBooks();
    }

    @PostMapping("/getBook")
    public Result getBook(@RequestBody AuthModel auth) {

        return reso.getBook(auth.getId());
    }

    @PostMapping("/getBooksByName")
    public Result getBooksByName(@RequestBody AuthModel auth) {
        return reso.getBookbyName(auth.getBookName());
    }


    @DeleteMapping("/deleteBook")
    public Result deleteBook(@RequestBody AuthModel auth) {
        try{
            if(auth.getKey()!=null && auth.getKey().equals(API_KEY))
                return reso.deleteBook(auth.getId());
            else if(auth.getKey()==null)
                return reso.getResult("Failure "," API key is not sent");
            else {
                return reso.getResult("Failure "," API key is invalid");
            }
        }
        catch(Exception e){
            return reso.getResult("Failure "," Something happened w");

        }
    }


    @PutMapping("/update2")
    public Result updateBook(@RequestBody updateBook book) {
        try{
            Book b=new Book();
            b.setId(Long.parseLong(book.getBookId()));
            b.setBookName(book.getBookName());
            b.setAuthorName(book.getAuthorName());
            b.setDescription(book.getDescription());
            b.setPrice(book.getPrice());
            b.setPublisher(book.getPublisher());
            System.out.println("cont+"+book);
            System.out.println("b:"+b);
            if(book.getBookId()!=null)
                return reso.updateBook(b);
            else {
                return reso.getResult("Failure "," Book not found");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return reso.getResult("Failure "," Something unexpected happened");
        }
    }

    @PutMapping("/update")
    public Result updateBook2(@RequestBody UpdateModel updateModel) {
        try{

            if(updateModel.getKey()!=null && updateModel.getKey().equals(API_KEY))
                return reso.updateBook(updateModel.getBook());
            else {
                return reso.getResult("Failure "," Book not found");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return reso.getResult("Failure "," Something unexpected happened");
        }
    }


}
