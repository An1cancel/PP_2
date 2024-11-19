package com.example.springBoot.controller;

import com.example.springBoot.model.User;
import com.example.springBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class MyController {

    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUser(Model model){
        model.addAttribute("users",userService.getUsersList());
        return "users/allUsers";
    }

    @GetMapping("/show")
    public String showUser(@RequestParam("id") int id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "users/new";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "users/edit";
        }
        userService.editUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete (@RequestParam("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
