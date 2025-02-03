package com.appdeveloperblog.app.ws.mobile_app_ws.ui_controller;

import com.appdeveloperblog.app.ws.mobile_app_ws.service.UserService;
import com.appdeveloperblog.app.ws.mobile_app_ws.service.impl.UserServiceImpl;
import com.appdeveloperblog.app.ws.mobile_app_ws.shared.dto.UserDTO;
import com.appdeveloperblog.app.ws.mobile_app_ws.ui.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.app.ws.mobile_app_ws.ui.model.response.UserDetailsResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
@Slf4j
public class UserController {

    @Autowired //instead of manually creating instances of objects, spring handles their life cycle and injection
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails){ //class thats going to convert the json payload document into java object
//        return null;

        //log.info("[createUser] in User Controller started execution");

        UserDetailsResponseModel returnValue = new UserDetailsResponseModel();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
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
