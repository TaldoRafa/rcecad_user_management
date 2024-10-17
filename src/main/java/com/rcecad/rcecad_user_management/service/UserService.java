package com.rcecad.rcecad_user_management.service;

import com.rcecad.rcecad_user_management.infra.mysql.User;
import com.rcecad.rcecad_user_management.infra.mysql.repository.UserRepository;
import com.rcecad.rcecad_user_management.mapper.UserMapper;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<User> listAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User save(UserPostRequestBody userPostRequestBody) {
        return userRepository.save(userMapper.toUser(userPostRequestBody));
    }

    public User login(String email, String password) {
        return null;
    }
}
