package com.rcecad.rcecad_user_management.controller;

import com.rcecad.rcecad_user_management.infra.mysql.Enterprise;
import com.rcecad.rcecad_user_management.infra.mysql.User;
import com.rcecad.rcecad_user_management.requests.LoginPostRequestBody;
import com.rcecad.rcecad_user_management.requests.UserGetRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import com.rcecad.rcecad_user_management.service.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@Log4j2
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> listAllPageable(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(userService.listAllPageable(pageable));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody @Valid LoginPostRequestBody loginPostRequestBody) {
        return ResponseEntity.ok(userService.login(loginPostRequestBody.getEmail(), loginPostRequestBody.getPassword()));
    }

    @GetMapping("email/{email}")
    public ResponseEntity<UserGetRequestBody> findByEmail(@PathVariable String email) {
        return null;
    }
}
