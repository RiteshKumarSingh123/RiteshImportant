package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Serializable>{

}
