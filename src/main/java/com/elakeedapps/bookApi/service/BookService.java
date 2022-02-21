package com.elakeedapps.bookApi.service;

import com.elakeedapps.bookApi.dao.BookDAO;
import com.elakeedapps.bookApi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAll() {
        return bookDAO.findAll();
    }

    public Book getById(Long id) {
        return bookDAO.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookDAO.save(book);
    }

    @Transactional
    public Book update(Long id,Book book) {
        Book updatedBook=this.getById(id);
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setTitle(book.getTitle());
        return updatedBook;
    }

    public void delete(Long id) {
        bookDAO.deleteById(id);
    }
}
