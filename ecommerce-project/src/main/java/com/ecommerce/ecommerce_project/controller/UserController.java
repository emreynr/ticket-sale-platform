package com.ecommerce.ecommerce_project.controller;

import com.ecommerce.ecommerce_project.entity.User;
import com.ecommerce.ecommerce_project.service.TicketService;
import com.ecommerce.ecommerce_project.service.UserService;
import com.ecommerce.ecommerce_project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    private UserService theUserService;

    @Autowired
    public UserController(UserService UserService) {
        theUserService = UserService;
    }

    // MAINPAGE
    @GetMapping("/anasayfa")
    public String MainPage(Model theModel) {

        //List<User> theUser = theUserService.findAll();
        //theModel.addAttribute("theUser", theUser);
        return "/main-page";
        // just for returns to main page
    }


    @GetMapping("/cinema")
    public String Cinema(Model model) {

        return "/category/cinema";
    }

    @GetMapping("/concert")
    public String Concert(Model model) {

        return "/category/concert";
    }

    @GetMapping("/theatre")
    public String Theatre(Model model) {

        return "/category/theatre";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("theUser") User theUser) {

        theUserService.createUser(theUser);

        return "redirect:/api/anasayfa";
    }

    @GetMapping("/ShowFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create an employee from Employee class
        User user = new User();

        theModel.addAttribute("theUser", user);

        return "/register/sign-up";
    }

    @GetMapping("/listAllUser")
    public String listAllUser(Model theModel) {

        List<User> theUser = theUserService.findAll();

        theModel.addAttribute("theUser", theUser);

        return "admin/all-users";
    }


    @GetMapping("/ShowFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {

        User getUser = theUserService.findById(theId);

        theModel.addAttribute("theUser", getUser);

        return "register/sign-up";
    }

    @GetMapping("/ShowFormForDelete")
    public String deleteUser(@RequestParam("userId") int theId) {

        theUserService.deleteById(theId);

        return "redirect:/api/listAllUser";
    }

    @PostMapping("/AdminSave")
    public String adminSave(@ModelAttribute("theUser") User user) {

        theUserService.createUser(user);

        return "redirect:/api/listAllUser";
    }

    @GetMapping("/ShowFormForUpdateAdmin")
    public String showFormForUpdateAdmin(@RequestParam("userId") int theId, Model theModel) {

        // create an employee from Employee class
        User getAnUser = theUserService.findById(theId);

        theModel.addAttribute("theUser", getAnUser);

        return "/admin/edit-user";
    }
}