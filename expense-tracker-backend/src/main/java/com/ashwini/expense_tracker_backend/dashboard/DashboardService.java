package com.ashwini.expense_tracker_backend.dashboard;

import com.ashwini.expense_tracker_backend.entity.Expense;
import com.ashwini.expense_tracker_backend.repository.ExpenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final ExpenseRepository expenseRepository;

    public DashboardService(
            ExpenseRepository expenseRepository) {

        this.expenseRepository = expenseRepository;
    }

    // TOTAL EXPENSES

    public DashboardResponse getTotalExpenses() {

        List<Expense> expenses =
                expenseRepository.findAll();

        double total = expenses.stream()

                .mapToDouble(Expense::getAmount)

                .sum();

        return new DashboardResponse(total);
    }

    // CATEGORY SUMMARY

    public Map<String, Double> getCategorySummary() {

        return expenseRepository.findAll()

                .stream()

                .collect(Collectors.groupingBy(

                        Expense::getCategory,

                        Collectors.summingDouble(
                                Expense::getAmount
                        )
                ));
    }

    public Map<String, Double> getMonthlySummary() {

        return expenseRepository.findAll()

                .stream()

                .collect(Collectors.groupingBy(

                        expense -> expense
                                .getExpenseDate()
                                .getMonth()
                                .toString(),

                        Collectors.summingDouble(
                                Expense::getAmount
                        )
                ));
    }
}