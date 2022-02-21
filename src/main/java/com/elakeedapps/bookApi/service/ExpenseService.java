package com.elakeedapps.bookApi.service;


import com.elakeedapps.bookApi.dao.ExpenseDAO;
import com.elakeedapps.bookApi.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenseService {

    private ExpenseDAO expenseDAO;

    @Autowired
    public ExpenseService(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    public List<Expense> getAll(){
        return expenseDAO.findAll();
    }

    public Expense getById(Long id){
        return expenseDAO.findById(id).orElse(null);
    }
    public Expense save(Expense expense){
        return expenseDAO.save(expense);
    }

    @Transactional
    public Expense update(Long id,Expense expense){
        Expense updatedExpense=this.getById(id);
        updatedExpense.setExpense(expense.getExpense());
        updatedExpense.setAmount(expense.getAmount());
        updatedExpense.setDescription(expense.getDescription());
        return updatedExpense;
    }

    public void delete(Long id){
        expenseDAO.deleteById(id);
    }

}
