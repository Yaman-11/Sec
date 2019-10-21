package com.example.second.Second.Services;

import com.example.second.Second.Entity.Books;
import com.example.second.Second.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Books> show() {
        List<Books> al = new ArrayList<>();
              for(Books b:bookRepository.findAll())
              {
                  al.add(b);

              }
              return al;


    }
    public String add(Books book)
    {
        if(book!=null) {
            if (book.getTitle().length() < 6) {

                bookRepository.save(book);

                return "ADDED SUCCESSFULLY";
            }
        }
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).toString();


    }


    public Optional<Books> find(int id) {

        return bookRepository.findById(id);



    }

    public String title(int id) {
        for(Books b:bookRepository.findAll())
        {
            if(b.getBookid()==id)
            {
                return b.getTitle();

            }

        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).toString();


    }

    public String  delete(int id )
    {
        bookRepository.deleteById(id);

        return "DELETED SUCCESSFULLY";


    }

    public String deleteAll() {
        bookRepository.deleteAll();
        return "ALL ENTRIES DELETED";

    }
}
//yaman
//sahana
//yahana