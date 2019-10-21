package com.example.second.Second.Controller;


import com.example.second.Second.Entity.Books;
import com.example.second.Second.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(method = RequestMethod.GET,value="/show")
    public List<Books> show() {
        return bookService.show();

    }
    @RequestMapping(method = RequestMethod.POST,value="/add")
    public String add(@RequestBody Books book)
    {
         return bookService.add(book);



    }
    @RequestMapping(method = RequestMethod.GET,value="/find/{id}")
    public Optional<Books> find(@PathVariable int id)
    {
        return bookService.find(id);


    }

    @RequestMapping(method = RequestMethod.GET,value="/title/{id}")
    public String title(@PathVariable int id)
    {
       return  bookService.title(id);


    }
    @RequestMapping(method = RequestMethod.POST,value="/delete/{id}")
    public String delete(@PathVariable int id)
    {
        return bookService.delete(id);


    }
    @RequestMapping(method = RequestMethod.POST,value="/deleteAll")
    public String deleteALL()
    {
        return bookService.deleteAll();

    }



}
