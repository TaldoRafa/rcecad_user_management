package com.rcecad.rcecad_user_management.infra.mysql.repository;

import com.rcecad.rcecad_user_management.infra.mysql.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Optional<Enterprise> findByUserData_EmailAndUserData_Password(String email, String password);
}
