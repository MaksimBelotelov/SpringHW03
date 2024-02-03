package com.belotelov.example3sem3hometask.services;

import com.belotelov.example3sem3hometask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private DataProcessingService dataProcessingService;
    private UserService userService;

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        userService.getNotificationService().notifyUser(newUser);
    }

    public void processRegistration(User user){
        dataProcessingService.addUserToList(user);
        userService.getNotificationService().notifyUser(user);
    }
}
