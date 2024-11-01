package com.rcecad.rcecad_user_management.requests;

import com.rcecad.rcecad_user_management.enums.PersonType;
import com.rcecad.rcecad_user_management.enums.validation.ValueOfEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersPostRequestBody {
    @NotEmpty(message = "This user`s person type cannot by empty!")
    @NotNull(message = "This user`s person type cannot by null!")
    @ValueOfEnum(enumClass = PersonType.class)
    private String personType;

    @NotEmpty(message = "This user`s full name cannot by empty!")
    @NotNull(message = "This user`s full name cannot by null!")
    private String fullName;

    @NotEmpty(message = "This user`s email cannot by empty!")
    @NotNull(message = "This user`s email name cannot by null!")
    private String email;

    @NotEmpty(message = "This user`s cpf cannot by empty!")
    @NotNull(message = "This user`s cpf name cannot by null!")
    @Size(min = 11, max = 11)
    private String cpf;

    @NotEmpty(message = "This user`s cnpj cannot by empty!")
    @NotNull(message = "This user`s cnpj cannot by null!")
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotEmpty(message = "This user`s password cannot by empty!")
    @NotNull(message = "This user`s password cannot by null!")
    @Size(min = 6, max = 20)
    private String password;
}
