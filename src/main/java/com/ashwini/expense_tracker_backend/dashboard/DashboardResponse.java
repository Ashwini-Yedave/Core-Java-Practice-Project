package com.ashwini.expense_tracker_backend.dashboard;

public class DashboardResponse {

        private Double totalExpenses;

        public DashboardResponse() {
        }

        public DashboardResponse(Double totalExpenses) {
            this.totalExpenses = totalExpenses;
        }

        public Double getTotalExpenses() {
            return totalExpenses;
        }

        public void setTotalExpenses(Double totalExpenses) {
            this.totalExpenses = totalExpenses;
        }
    }

