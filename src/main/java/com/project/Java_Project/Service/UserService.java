package com.project.Java_Project.Service;

import com.project.Java_Project.Web.dto.UserRegistrationDto;
import com.project.Java_Project.model.Student;

public interface UserService {
    Student save(UserRegistrationDto registrationDto);
}
