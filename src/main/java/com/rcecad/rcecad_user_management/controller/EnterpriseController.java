package com.rcecad.rcecad_user_management.controller;

import com.rcecad.rcecad_user_management.infra.mysql.Enterprise;
import com.rcecad.rcecad_user_management.requests.EnterprisePostRequestBody;
import com.rcecad.rcecad_user_management.requests.LoginPostRequestBody;
import com.rcecad.rcecad_user_management.service.EnterpriseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/enterprises")
@Log4j2
@RequiredArgsConstructor
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    @GetMapping
    public ResponseEntity<Page<Enterprise>> listAllPageable(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(enterpriseService.lisAllPageable(pageable));
    }

    @PostMapping
    public ResponseEntity<Enterprise> create(@RequestBody @Valid EnterprisePostRequestBody enterprisePostRequestBody) {
        return new ResponseEntity<>(enterpriseService.save(enterprisePostRequestBody), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<Enterprise> login(@RequestBody @Valid LoginPostRequestBody loginPostRequestBody) {
        return new ResponseEntity<>(
                enterpriseService.login(loginPostRequestBody.getEmail(), loginPostRequestBody.getPassword()),
                HttpStatus.ACCEPTED
        );
    }
}
