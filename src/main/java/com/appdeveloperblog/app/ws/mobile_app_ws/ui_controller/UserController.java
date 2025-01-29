package com.appdeveloperblog.app.ws.mobile_app_ws.ui_controller;

import com.appdeveloperblog.app.ws.mobile_app_ws.ui.model.request.UserDetailsRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public String createUser(@RequestBody UserDetailsRequestModel userDetails){ //class thats going to convert the json payload document into java object
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
