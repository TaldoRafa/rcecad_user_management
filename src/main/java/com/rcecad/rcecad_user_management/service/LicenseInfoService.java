package com.rcecad.rcecad_user_management.service;

import com.rcecad.rcecad_user_management.infra.mysql.repository.LicenseInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LicenseInfoService {
    private final LicenseInfoRepository licenseInfoRepository;
}
