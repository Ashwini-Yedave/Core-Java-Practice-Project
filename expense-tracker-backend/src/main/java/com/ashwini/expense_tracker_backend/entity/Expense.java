package com.ashwini.expense_tracker_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

//entity means database table name
//and this parameters means column names
@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    //id means primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment ID
    private Long id;

    private String title;
    private Double amount;
    private String category;
    private LocalDate expenseDate;
    private String description;

    @ManyToOne //One User → Many Expenses
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("expenses")
    private User user;
    // getters and setters
}
