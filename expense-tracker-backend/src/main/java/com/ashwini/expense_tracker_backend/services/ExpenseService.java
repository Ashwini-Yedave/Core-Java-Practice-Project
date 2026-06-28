package com.ashwini.expense_tracker_backend.services;

import com.ashwini.expense_tracker_backend.entity.Expense;
import com.ashwini.expense_tracker_backend.entity.User;
import com.ashwini.expense_tracker_backend.repository.ExpenseRepository;
import com.ashwini.expense_tracker_backend.repository.UserRepository;
import com.ashwini.expense_tracker_backend.dto.ExpenseResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository) {

        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    // CREATE

    public Expense addExpense(
            Expense expense,
            String email) {

        User user = userRepository

                .findByEmail(email)

                .orElseThrow(() ->

                        new RuntimeException(
                                "User not found"
                        )
                );

        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    // GET ALL
    public List<Expense> getAllExpenses(
            String email) {

        User user = userRepository

                .findByEmail(email)

                .orElseThrow(() ->

                        new RuntimeException(
                                "User not found"
                        )
                );

        return expenseRepository.findByUserId(
                user.getId()
        );
    }

    // GET BY ID
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    // DELETE
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // UPDATE
    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDescription(updatedExpense.getDescription());
        expense.setExpenseDate(updatedExpense.getExpenseDate());

        return expenseRepository.save(expense);
    }

    public ExpenseResponse convertToResponse(
            Expense expense) {

        ExpenseResponse response =
                new ExpenseResponse();

        response.setId(
                expense.getId()
        );

        response.setTitle(
                expense.getTitle()
        );

        response.setAmount(
                expense.getAmount()
        );

        response.setCategory(
                expense.getCategory()
        );

        response.setExpenseDate(
                expense.getExpenseDate()
        );

        response.setDescription(
                expense.getDescription()
        );

        response.setUserId(
                expense.getUser().getId()
        );

        response.setUserName(
                expense.getUser().getName()
        );

        return response;
    }
}
