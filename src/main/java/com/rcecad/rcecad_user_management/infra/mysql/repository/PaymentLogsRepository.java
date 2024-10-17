package com.rcecad.rcecad_user_management.infra.mysql.repository;

import com.rcecad.rcecad_user_management.infra.mysql.PaymentLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentLogsRepository extends JpaRepository<PaymentLogs, Long> {
}
