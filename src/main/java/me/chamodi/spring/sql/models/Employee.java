package me.chamodi.spring.sql.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee extends Person{
    @Id
    private String empNo;
    private double salary;
    @ManyToOne
    private Department department;
    @ManyToMany(mappedBy = "employees")
    private List<Project> project;


    public List<Project> getProject() {
        return project;
    }

    public Employee(){

    }

}
