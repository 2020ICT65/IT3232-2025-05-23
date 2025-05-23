package me.chamodi.spring.sql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.EntityNotFoundException;
import me.chamodi.spring.sql.models.Department;
import me.chamodi.spring.sql.repo.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;

    @GetMapping
    public List<Department> getDepts(){
        return repo.findAll();
    }
   
    public Department getDept(String id) {
        if(repo.findById(id).isEmpty()){
            throw new EntityNotFoundException("Department Not Found!");
        }
        return repo.findById(id).get();
    }
    
    @PostMapping
    public String addDept(@RequestBody Department department) {
        repo.save(department);
        return "New Department Created!";
    }
    
    @PutMapping("/{id}")
    public String updateDept(@PathVariable String id, @RequestBody Department department) {
        if(repo.findById(id).isEmpty()){
            return "Couldn't find the department!";
        }
        repo.save(department);
        return "Updated Successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteDept(@PathVariable("id") String id) {
        if(repo.findById(id).isEmpty()){
            return "Couldn't find the department!";
        }
        repo.deleteById(id);;
        return "Department Deleted Successfully!";
    }
}
