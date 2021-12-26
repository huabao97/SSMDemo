package com.kg.service;

import com.kg.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> queryAllStudent();
}
