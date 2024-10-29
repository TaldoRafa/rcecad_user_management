package com.rcecad.rcecad_user_management.mapper;

import com.rcecad.rcecad_user_management.infra.mysql.Enterprise;
import com.rcecad.rcecad_user_management.infra.mysql.UserData;
import com.rcecad.rcecad_user_management.requests.EnterpriseGetRequestBody;
import com.rcecad.rcecad_user_management.requests.EnterprisePostRequestBody;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EnterpriseMapper {
    public Enterprise toEnterprise(EnterprisePostRequestBody enterprisePostRequestBody) {
        Enterprise enterprise = new Enterprise();

        enterprise.setUserData(new UserData());

        enterprise.getUserData().setCreateAt(LocalDate.now());
        enterprise.getUserData().setName(enterprisePostRequestBody.getName());
        enterprise.getUserData().setEmail(enterprisePostRequestBody.getEmail());
        enterprise.setCnpj(enterprisePostRequestBody.getCnpj());
        enterprise.getUserData().setPassword(enterprisePostRequestBody.getPassword());

        return enterprise;
    }

    public EnterpriseGetRequestBody toEnterpriseGetRequestBody(Enterprise enterprise) {
        EnterpriseGetRequestBody enterpriseGetRequestBody = new EnterpriseGetRequestBody();

        enterpriseGetRequestBody.setId(enterprise.getId());
        enterpriseGetRequestBody.setName(enterprise.getUserData().getName());
        enterpriseGetRequestBody.setEmail(enterprise.getUserData().getEmail());
        enterpriseGetRequestBody.setCnpj(enterprise.getCnpj());

        return enterpriseGetRequestBody;
    }
}
