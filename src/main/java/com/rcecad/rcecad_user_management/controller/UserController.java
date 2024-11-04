package com.rcecad.rcecad_user_management.controller;

import com.rcecad.rcecad_user_management.requests.LoginPostRequestBody;
import com.rcecad.rcecad_user_management.requests.UserGetRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPutRequestBody;
import com.rcecad.rcecad_user_management.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
    })
    public ResponseEntity<List<UserGetRequestBody>> listAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.listAll());
    }

    @GetMapping("email/{email}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "When user Does Not Exist in The Database")
    })
    public ResponseEntity<UserGetRequestBody> findByEmail(@PathVariable String email) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findByEmail(email));
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

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UserPutRequestBody userPutRequestBody) {
        userService.replace(userPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
