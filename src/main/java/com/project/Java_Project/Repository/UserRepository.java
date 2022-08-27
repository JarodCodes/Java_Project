package com.project.Java_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Java_Project.model.Student;
// import com.project.Java_Project.model.Student;
// import com.project.Java_Project.model.User;

@Repository
public interface UserRepository extends JpaRepository<Student, Long>{
    Student findByEmail(String username);
}
