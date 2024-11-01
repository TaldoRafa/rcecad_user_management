package com.rcecad.rcecad_user_management.controller;

import com.rcecad.rcecad_user_management.requests.LoginPostRequestBody;
import com.rcecad.rcecad_user_management.requests.UserGetRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import com.rcecad.rcecad_user_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@Log4j2
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("pageable")
    public ResponseEntity<Page<UserGetRequestBody>> listAllUsersPageable(Pageable pageable) {
        Page<UserGetRequestBody> users = userService.listAllUsersPageable(pageable);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @GetMapping
    public ResponseEntity<List<UserGetRequestBody>> listAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.listAll());
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        userService.save(userPostRequestBody);
        Boolean created = true;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @PostMapping("login")
    public ResponseEntity<UserGetRequestBody> login(@RequestBody @Valid LoginPostRequestBody loginPostRequestBody) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(
                        userService.login(loginPostRequestBody.getEmail(), loginPostRequestBody.getPassword())
                );
    }

    @GetMapping("email/{email}")
    public ResponseEntity<UserGetRequestBody> findByEmail(@PathVariable String email) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findByEmail(email));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
