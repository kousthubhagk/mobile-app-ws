package com.appdeveloperblog.app.ws.mobile_app_ws.service.impl;

import com.appdeveloperblog.app.ws.mobile_app_ws.io.entity.UserEntity;
import com.appdeveloperblog.app.ws.mobile_app_ws.repository.UserRepository;
import com.appdeveloperblog.app.ws.mobile_app_ws.service.UserService;
import com.appdeveloperblog.app.ws.mobile_app_ws.shared.Utils;
import com.appdeveloperblog.app.ws.mobile_app_ws.shared.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //marking the class as a service layer component - it tells spring that this contains the business logic and should be managed as a spring bean
//this also supports auto implementation via interfaces, then using autowired to inject the implementation - use the service class as type but implementation will be injected automatically
//enables AOP - aspect oriented programming
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public UserDTO createUser(UserDTO user) {

        //log.info("[createUser] in User Service started execution");

        /*
//        UserEntity storedUserDetails = userRepository.findByEmail(user.getEmail());
        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
         */

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        //the dto variables must match the entity variables

        String publicUserId = utils.generateUserId(30);

        //as of now hardcoding the details
        userEntity.setEncryptedPassword("test");
//        userEntity.setUserId("testUserId");
        userEntity.setUserId(publicUserId);


        //now saving into db
        UserEntity storedUserDetails = userRepository.save(userEntity);

        //now return this info back to the rest controller
        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;

        //now we are ready to send http request for create new user  and run the application

//        return null;
    }
}
