package com.appdeveloperblog.app.ws.mobile_app_ws.ui.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
