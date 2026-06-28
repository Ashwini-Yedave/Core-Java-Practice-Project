package com.ashwini.expense_tracker_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExpenseResponse { //for api request and response

    private Long id;

    private String title;

    private Double amount;

    private String category;

    private LocalDate expenseDate;

    private String description;

    private Long userId;

    private String userName;
}