package com.rcecad.rcecad_user_management.service;

import com.rcecad.rcecad_user_management.infra.mysql.Enterprise;
import com.rcecad.rcecad_user_management.infra.mysql.repository.EnterpriseRepository;
import com.rcecad.rcecad_user_management.mapper.EnterpriseMapper;
import com.rcecad.rcecad_user_management.requests.EnterpriseGetRequestBody;
import com.rcecad.rcecad_user_management.requests.EnterprisePostRequestBody;
import com.rcecad.rcecad_user_management.settings.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
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

    public EnterpriseGetRequestBody save(EnterprisePostRequestBody enterprisePostRequestBody) {
        Enterprise saved = enterpriseRepository.save(enterpriseMapper.toEnterprise(enterprisePostRequestBody));
        return enterpriseMapper.toEnterpriseGetRequestBody(saved);
    }

    public EnterpriseGetRequestBody login(String email, String password) {
        Enterprise enterprise = enterpriseRepository
                .findByUserData_EmailAndUserData_Password(email, password)
                .orElseThrow(() -> new BadRequestException("User not Found"));

        return enterpriseMapper.toEnterpriseGetRequestBody(enterprise);
    }
}
