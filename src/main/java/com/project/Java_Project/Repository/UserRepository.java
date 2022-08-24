package com.project.Java_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Java_Project.person.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
