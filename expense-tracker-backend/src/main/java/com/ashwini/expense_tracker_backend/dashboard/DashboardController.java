package com.ashwini.expense_tracker_backend.dashboard;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping("/dashboard")

@CrossOrigin("*")

public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService = dashboardService;
    }

    // TOTAL

    @GetMapping("/total-expenses")

    public DashboardResponse getTotalExpenses() {

        return dashboardService.getTotalExpenses();
    }

    // CATEGORY

    @GetMapping("/category-summary")

    public Map<String, Double> getCategorySummary() {

        return dashboardService.getCategorySummary();
    }

    @GetMapping("/monthly-summary")

    public Map<String, Double> getMonthlySummary() {

        return dashboardService.getMonthlySummary();
    }
}