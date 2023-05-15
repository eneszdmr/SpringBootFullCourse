package com.example.cruddemo.dao;

import com.example.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    Student findByFirstName(String firstName);
 }
