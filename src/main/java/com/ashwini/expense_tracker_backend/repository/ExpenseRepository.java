package com.ashwini.expense_tracker_backend.repository;

import com.ashwini.expense_tracker_backend.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
}
