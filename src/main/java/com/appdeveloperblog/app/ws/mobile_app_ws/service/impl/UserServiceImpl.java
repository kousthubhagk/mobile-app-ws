package com.appdeveloperblog.app.ws.mobile_app_ws.service.impl;

import com.appdeveloperblog.app.ws.mobile_app_ws.io.entity.UserEntity;
import com.appdeveloperblog.app.ws.mobile_app_ws.repository.UserRepository;
import com.appdeveloperblog.app.ws.mobile_app_ws.service.UserService;
import com.appdeveloperblog.app.ws.mobile_app_ws.shared.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //marking the class as a service layer component - it tells spring that this contains the business logic and should be managed as a spring bean
//this also supports auto implementation via interfaces, then using autowired to inject the implementation - use the service class as type but implementation will be injected automatically
//enables AOP - aspect oriented programming
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        //the dto variables must match the entity variables

        //as of now hardcoding the details
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");


        //now saving into db
        UserEntity storedUserDetails = userRepository.save(userEntity);

        //now return this info back to the rest controller
        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;

        //now we are ready to send http request for create new user  and run the application

        return null;
    }
}
