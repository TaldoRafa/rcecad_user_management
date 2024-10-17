package com.rcecad.rcecad_user_management.infra.mysql.repository;

import com.rcecad.rcecad_user_management.infra.mysql.LicenseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseInfoRepository extends JpaRepository<LicenseInfo, Long> {
}
