package com.elakeedapps.bookApi.controller;

import com.elakeedapps.bookApi.model.Book;
import com.elakeedapps.bookApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok().body(bookService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(bookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book createdBook=bookService.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBook.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id,@RequestBody Book book){
        return ResponseEntity.ok().body(bookService.update(id,book));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
