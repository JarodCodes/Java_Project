package com.project.Java_Project.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Java_Project.Repository.UserRepository;
import com.project.Java_Project.Web.dto.UserRegistrationDto;
import com.project.Java_Project.model.Course;
import com.project.Java_Project.model.Student;


@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Student save(UserRegistrationDto registrationDto) {
		Student user = new Student(registrationDto.getName(), 
				registrationDto.getAddress(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Course("PRG381")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Student user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid!!");
		}
		return new org.springframework.security.core.userdetails.User(user.getemail(), user.getStudentpassword(), mapRolesToAuthorities(user.getCourse()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Course> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getCoursename())).collect(Collectors.toList());
	}
	
}