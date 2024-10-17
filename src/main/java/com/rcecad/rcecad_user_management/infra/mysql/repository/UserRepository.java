package com.rcecad.rcecad_user_management.infra.mysql.repository;

import com.rcecad.rcecad_user_management.infra.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserData_EmailAndUserData_Password(String email, String password);
    Optional<User> findByUserData_Email(String email);
}
