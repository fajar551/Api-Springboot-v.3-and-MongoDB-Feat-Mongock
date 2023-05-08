package com.fajar.mongo.springbootmongodbtutorial.controller;

//import com.programming.techie.mongo.service.ExpenseService;
//import lombok.RequiredArgsConstructor;
import com.fajar.mongo.springbootmongodbtutorial.model.Expense;
import com.fajar.mongo.springbootmongodbtutorial.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/expense")
//@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpense()) ;
    }
    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpensByName(@PathVariable String name){
        return ResponseEntity.ok(expenseService.getExpenseByName(name)) ;
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build() ;
    }
}
