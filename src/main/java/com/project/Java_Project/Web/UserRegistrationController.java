package com.project.Java_Project.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Java_Project.Service.UserService;
import com.project.Java_Project.Web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("stud")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String ShowRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerStudentAccount(@ModelAttribute("stud") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration";
    }

    @GetMapping("/login")
	public String login() {
		return "login";
	}
}
