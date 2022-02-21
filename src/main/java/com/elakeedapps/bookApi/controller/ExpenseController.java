package com.elakeedapps.bookApi.controller;


import com.elakeedapps.bookApi.model.Expense;
import com.elakeedapps.bookApi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Expense> getAllExpenses() {
        return expenseService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(expenseService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(expenseService.save(expense).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody Expense expense) {
        return ResponseEntity.ok().body(expenseService.update(id, expense));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") Long id) {
        expenseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
