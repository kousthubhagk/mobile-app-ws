package com.appdeveloperblog.app.ws.mobile_app_ws.service.impl;

import com.appdeveloperblog.app.ws.mobile_app_ws.service.UserService;
import com.appdeveloperblog.app.ws.mobile_app_ws.shared.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service //marking the class as a service layer component - it tells spring that this contains the business logic and should be managed as a spring bean
//this also supports auto implementation via interfaces, then using autowired to inject the implementation - use the service class as type but implementation will be injected automatically
//enables AOP
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO createUser(UserDTO user) {
        return null;
    }
}
