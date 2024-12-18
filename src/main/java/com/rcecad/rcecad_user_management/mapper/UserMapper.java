package com.rcecad.rcecad_user_management.mapper;

import com.rcecad.rcecad_user_management.infra.mysql.User;
import com.rcecad.rcecad_user_management.infra.mysql.UserData;
import com.rcecad.rcecad_user_management.requests.UserGetRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPutRequestBody;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {
    public User toUser(UserPostRequestBody userPostRequestBody) {
        User user = new User();

        user.setUserData(new UserData());

        user.getUserData().setCreateAt(LocalDate.now());
        user.getUserData().setName(userPostRequestBody.getName());
        user.setCpf(userPostRequestBody.getCpf());
        user.getUserData().setEmail(userPostRequestBody.getEmail());
        user.getUserData().setPassword(userPostRequestBody.getPassword());

        return user;
    }

    public UserGetRequestBody toUserGetRequestBody(User user) {
        return UserGetRequestBody.builder()
                .id(user.getId())
                .cpf(user.getCpf())
                .name(user.getUserData().getName())
                .email(user.getUserData().getEmail())
                .build();
    }

    public User toUser(UserPutRequestBody userPutRequestBody) {
        UserData userData = UserData.builder()
                .name(userPutRequestBody.getName())
                .email(userPutRequestBody.getEmail())
                .password(userPutRequestBody.getPassword())
                .build();

        return User.builder()
                .cpf(userPutRequestBody.getCpf())
                .userData(userData)
                .build();
    }
}
