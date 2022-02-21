package com.elakeedapps.bookApi.dao;

import com.elakeedapps.bookApi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book,Long> {
}
