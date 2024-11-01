package com.rcecad.rcecad_user_management.service;

import com.rcecad.rcecad_user_management.infra.mysql.User;
import com.rcecad.rcecad_user_management.infra.mysql.repository.UserRepository;
import com.rcecad.rcecad_user_management.mapper.UserMapper;
import com.rcecad.rcecad_user_management.requests.UserGetRequestBody;
import com.rcecad.rcecad_user_management.requests.UserPostRequestBody;
import com.rcecad.rcecad_user_management.settings.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserGetRequestBody> listAllUsersPageable(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(userMapper::toUserGetRequestBody);
    }

    public List<UserGetRequestBody> listAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserGetRequestBody)
                .toList();
    }

    @Transactional
    public UserGetRequestBody save(UserPostRequestBody userPostRequestBody) {
        return userMapper.toUserGetRequestBody(
                userRepository.save(userMapper.toUser(userPostRequestBody))
        );
    }

    public UserGetRequestBody login(String email, String password) {
        return userMapper.toUserGetRequestBody(
                userRepository.findByUserData_EmailAndUserData_Password(email, password)
                        .orElseThrow(() -> new BadRequestException("User not Found"))
        );
    }

    public UserGetRequestBody findByEmail(String email) {
        return userMapper.toUserGetRequestBody(
                userRepository.findByUserData_Email(email)
                        .orElseThrow(() -> new BadRequestException("User not Found"))
        );
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.delete(findByIdOrElseThrowBadRequestException(id));
    }

    @Transactional
    public void deleteByEmail(String email) {
        userRepository.deleteByUserData_Email(email);
    }

    public User findByIdOrElseThrowBadRequestException(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("User not Found"));
    }
}
