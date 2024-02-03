package com.belotelov.example3sem3hometask.controllers;

import com.belotelov.example3sem3hometask.domain.User;
import com.belotelov.example3sem3hometask.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private RegistrationService service;

    public UserController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService()
                .getRepository()
                .getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user);
        return "User added from body";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam("name") String name,
                                   @RequestParam("age") int age,
                                   @RequestParam("email") String email) {
        service.processRegistration(name, age, email);
        return "User added from params";
    }
}
