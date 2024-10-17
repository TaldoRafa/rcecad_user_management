package com.rcecad.rcecad_user_management.service;

import com.rcecad.rcecad_user_management.infra.mysql.Enterprise;
import com.rcecad.rcecad_user_management.infra.mysql.repository.EnterpriseRepository;
import com.rcecad.rcecad_user_management.mapper.EnterpriseMapper;
import com.rcecad.rcecad_user_management.requests.EnterprisePostRequestBody;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseMapper enterpriseMapper;

    public Page<Enterprise> lisAllPageable(Pageable pageable) {
        return enterpriseRepository.findAll(pageable);
    }

    public Enterprise save(EnterprisePostRequestBody enterprisePostRequestBody) {
        return enterpriseRepository.save(enterpriseMapper.toEnterprise(enterprisePostRequestBody));
    }

    public Enterprise login(String email, String password) {
        return enterpriseRepository.findByUserData_EmailAndUserData_Password(email, password).orElse(null);
    }
}
