package com.springexample.softdeleteimplementations.services;

import javax.persistence.EntityManager;

import com.springexample.softdeleteimplementations.models.entities.Book;
import com.springexample.softdeleteimplementations.models.repository.BookRepository;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    // get entity manager
    @Autowired
    private EntityManager entityManager;

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

    public Iterable<Book> findAll(boolean bool){
        Session session = entityManager.unwrap(Session.class); // get session
        Filter filter = session.enableFilter("statusDeleted"); // enable filter 
        filter.setParameter("isDeleted", bool); // set parameter (isDeleted) value, do this before bookService.findAll()
        Iterable<Book> books = bookRepository.findAll(); // get all books and assign value to object
        session.disableFilter("statusDeleted"); // disable a filter
        return books;
    }
}
