package com.project.Java_Project.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.Java_Project.Web.dto.UserRegistrationDto;
import com.project.Java_Project.model.Student;

public interface UserService extends UserDetailsService{
	Student save(UserRegistrationDto registrationDto);
}
