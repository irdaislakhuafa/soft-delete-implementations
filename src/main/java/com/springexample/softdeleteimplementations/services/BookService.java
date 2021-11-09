package com.springexample.softdeleteimplementations.services;

import java.util.List;

import com.springexample.softdeleteimplementations.models.entities.Book;
import com.springexample.softdeleteimplementations.models.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public void removeById(String id) {
        bookRepository.deleteById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(String id) {
        return bookRepository.findById(id).get();
    }
}
