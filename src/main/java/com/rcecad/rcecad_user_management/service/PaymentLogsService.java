package com.rcecad.rcecad_user_management.service;

import com.rcecad.rcecad_user_management.infra.mysql.repository.PaymentLogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentLogsService {
    private final PaymentLogsRepository paymentLogsRepository;
}
