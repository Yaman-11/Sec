package com.example.second.Second.Repository;

import com.example.second.Second.Entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Integer> {


}
