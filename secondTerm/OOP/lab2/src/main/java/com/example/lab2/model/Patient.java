package com.example.lab2.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    private  Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "procedures")
    private String procedures;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "medicines")
    private String medicines;

    @Column(name = "operations")
    private String operations;

    @Column(name = "health_status")
    private String health_status;
}
