package com.elakeedapps.bookApi.dao;

import com.elakeedapps.bookApi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDAO extends JpaRepository<Expense,Long> {
}
