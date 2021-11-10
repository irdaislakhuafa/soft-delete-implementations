package com.springexample.softdeleteimplementations.models.repository;

import java.util.List;

import com.springexample.softdeleteimplementations.models.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
    // find all books by deleted
    List<Book> findAllByDeleted(boolean bool);

    // find by id where deleted is false
    Book findByIdAndDeletedFalse(String id);
}
