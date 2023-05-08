package com.fajar.mongo.springbootmongodbtutorial.service;
import com.fajar.mongo.springbootmongodbtutorial.repository.ExpenseRepository;
import com.fajar.mongo.springbootmongodbtutorial.model.Expense;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private Object expenseService;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository= expenseRepository;
    }
    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    @GetMapping
    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Exponse by Name %s", name)));
    }
    @DeleteMapping("{id}")
    public void deleteExpense(String id){
    }
}
