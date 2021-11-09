package com.springexample.softdeleteimplementations.models.repository;

import com.springexample.softdeleteimplementations.models.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

}
