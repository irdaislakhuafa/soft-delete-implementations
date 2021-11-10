package com.springexample.softdeleteimplementations.controllers;

import com.springexample.softdeleteimplementations.models.dto.ResponseAPI;
import com.springexample.softdeleteimplementations.models.entities.Book;
import com.springexample.softdeleteimplementations.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean bool) {
        try {
            return ResponseEntity.ok(new ResponseAPI(HttpStatus.OK, "Success", bookService.findAll(bool)));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(
                    new ResponseAPI(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get all books", null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(new ResponseAPI(HttpStatus.OK, "Success", bookService.save(book)));
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(
                    new ResponseAPI(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save a book", null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            Book book = bookService.findById(id);
            bookService.removeById(id);
            return ResponseEntity.ok(new ResponseAPI(HttpStatus.OK, "Success", book));
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to remove data with ID : " + id, null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
