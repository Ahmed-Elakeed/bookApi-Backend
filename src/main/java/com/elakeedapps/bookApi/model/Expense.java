package com.elakeedapps.bookApi.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String expense;

    private String description;

    @Column(nullable = false)
    private BigDecimal amount;

    public Expense() {
    }

    public Expense(String expense, String description, BigDecimal amount) {
        this.expense = expense;
        this.description = description;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expense='" + expense + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
