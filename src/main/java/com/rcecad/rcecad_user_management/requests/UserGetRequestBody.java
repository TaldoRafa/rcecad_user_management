package com.rcecad.rcecad_user_management.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGetRequestBody {
    private Long id;
    private String cpf;
    private String name;
    private String email;
}
