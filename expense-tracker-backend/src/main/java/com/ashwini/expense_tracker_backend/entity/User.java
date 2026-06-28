package com.ashwini.expense_tracker_backend.entity;
import jakarta.persistence.*; //@Entity comes from that
import lombok.Getter;
import lombok.Setter;

@Getter//no need to write seprate ,method for every single parametr
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
}
