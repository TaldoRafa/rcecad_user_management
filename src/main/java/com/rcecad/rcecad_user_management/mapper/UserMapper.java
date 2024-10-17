package com.rcecad.rcecad_user_management.mapper;

import com.rcecad.rcecad_user_management.infra.mysql.User;
import com.rcecad.rcecad_user_management.infra.mysql.UserData;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {
    public User toUser(UserPostRequestBody userPostRequestBody) {
        User user = new User();

        user.setUserData(new UserData());

        user.getUserData().setCreateAt(LocalDate.now());
        user.getUserData().setName(userPostRequestBody.getName());
        user.getUserData().setUsername(userPostRequestBody.getUsername());
        user.getUserData().setEmail(userPostRequestBody.getEmail());
        user.getUserData().setPassword(userPostRequestBody.getPassword());

        return user;
    }
}
