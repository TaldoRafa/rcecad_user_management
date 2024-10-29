package com.rcecad.rcecad_user_management.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseGetRequestBody {
    private Long id;
    private String cnpj;
    private String name;
    private String email;
}
