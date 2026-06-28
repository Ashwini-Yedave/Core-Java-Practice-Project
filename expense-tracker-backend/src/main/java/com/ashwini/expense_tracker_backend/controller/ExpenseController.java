package com.ashwini.expense_tracker_backend.controller;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import com.ashwini.expense_tracker_backend.entity.Expense;
import com.ashwini.expense_tracker_backend.services.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import com.ashwini.expense_tracker_backend.dto.ExpenseResponse;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // CREATE
    @PostMapping
    public ExpenseResponse addExpense(

            @RequestBody Expense expense,

            Authentication authentication) {

        String email =
                authentication.getName();

        Expense savedExpense =

                expenseService.addExpense(
                        expense,
                        email
                );

        return expenseService
                .convertToResponse(
                        savedExpense
                );
    }


    @GetMapping
    public List<ExpenseResponse> getAllExpenses(

            Authentication authentication) {

        String email =
                authentication.getName();

        return expenseService

                .getAllExpenses(email)

                .stream()

                .map(
                        expenseService::convertToResponse
                )

                .toList();
    }
    // GET BY ID
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Expense deleted successfully";
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUserId(@PathVariable Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }
}
