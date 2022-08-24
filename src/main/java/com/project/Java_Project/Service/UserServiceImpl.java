package com.project.Java_Project.Service;

import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Java_Project.Repository.UserRepository;
import com.project.Java_Project.Web.dto.UserRegistrationDto;
import com.project.Java_Project.model.Course;
import com.project.Java_Project.model.Student;


@Service
public class UserServiceImpl implements UserService{

    
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public Student save(UserRegistrationDto registrationDto) {
		Student user = new Student(registrationDto.getName(), 
				registrationDto.getAddress(), registrationDto.getEmail(),
				registrationDto.getPassword(), Arrays.asList(new Course("PRG381")));
		
		return userRepository.save(user);
	}
    
}
