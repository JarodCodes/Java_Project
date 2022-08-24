package com.project.Java_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.Java_Project.Repository.UserRepository;
import com.project.Java_Project.person.User;


@Controller
public class UserController {
    @Autowired
    private UserRepository uRepo;

    @GetMapping("/ShowUsers")//Returns a list of users ({"/ShowUsers","/","/list"}) vir meer as een adress
    public ModelAndView showUser(){
        ModelAndView mav = new ModelAndView("list-users");//attach html to model
        List<User> list = uRepo.findAll();//attach list of users from database
        mav.addObject("users", list);//pass list of users to model and view object
        return mav;//returns model and view object with all details attached
    }

    @GetMapping("/addUserForm")//shows the add user form
    public ModelAndView addUserForm(){
        ModelAndView mav = new ModelAndView("add-user-form");
        User newUser = new User();
        mav.addObject("user", newUser);//new user object sent to the form to fill
        return mav;
    }

    @PostMapping("/saveUser")//form submitted along with user from it
    public String saveUser(@ModelAttribute User user){//user from page bound to user object, returns string because we will redirect
        uRepo.save(user);//saved to database, if there is a existing id it will update the existing entry
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userId){//request userId we created in the web page
        ModelAndView mav = new ModelAndView("add-user-form");
        User user = uRepo.findById(userId).get();//retreive user from database with ID
        mav.addObject("user", user);//will send user to the user form filling all fields with found data because the form has the fields specified in its inputs
        return mav;
    }

    @GetMapping("/deleteUser")//deleteUser page called (its a get because we are returning a page)
    public String deleteUser(@RequestParam Long userId){//triggers delete user method which requests the userId passed from web
        uRepo.deleteById(userId);//search and delete from database using ID
        return "redirect:/list";//refresh page by redirecting to it
    }
}
