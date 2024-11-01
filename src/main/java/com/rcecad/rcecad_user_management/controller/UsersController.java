package com.rcecad.rcecad_user_management.controller;

import com.rcecad.rcecad_user_management.mapper.UserMapper;
import com.rcecad.rcecad_user_management.requests.UsersPostRequestBody;
import com.rcecad.rcecad_user_management.service.EnterpriseService;
import com.rcecad.rcecad_user_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/users")
@Controller
@RequiredArgsConstructor
public class UsersController {
    private final UserMapper userMapper;
    private final UserService userService;
    private final EnterpriseService enterpriseService;

    @GetMapping("save")
    public ResponseEntity<Void> createUsers(@RequestBody @Valid UsersPostRequestBody usersPostRequestBody) {
        return ResponseEntity.ok().build();
    }
}
