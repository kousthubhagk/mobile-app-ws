package com.appdeveloperblog.app.ws.mobile_app_ws.repository;

import com.appdeveloperblog.app.ws.mobile_app_ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //DAO need not even be created
    //if this did not extend crud repository, then for each crud operation, a separate method has to be created then business logic written - open db connection, do operation then close the connection
    //or add methods that use hibernate then for each operation create a separate method that crud

//    UserEntity findUsreByEmail(String email); //it will do it on its own
}
