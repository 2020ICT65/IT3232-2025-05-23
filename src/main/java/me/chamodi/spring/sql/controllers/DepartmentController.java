package me.chamodi.spring.sql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.chamodi.spring.sql.models.Department;
import me.chamodi.spring.sql.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/depts")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("")
    public ResponseEntity<List<Department>>getDepts(){
        return new ResponseEntity<List<Department>>(service.getDepts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department>getDept(@PathVariable("id") String id){
        return new ResponseEntity<Department>(service.getDept(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Department>addDept(@RequestBody Department department){
        return new ResponseEntity<Department>(service.addDept(department),HttpStatus.OK);
    }

}
