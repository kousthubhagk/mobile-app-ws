package com.appdeveloperblog.app.ws.mobile_app_ws.ui.model.response;

import lombok.Data;

@Data
public class UserDetailsResponseModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
