package com.rcecad.rcecad_user_management.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPostRequestBody {
    @NotEmpty(message = "The user name cannot be empty")
    @NotNull(message = "The user name cannot be null")
    @Schema(description = "This is the User's name", example = "Rafael Roani Gonçalves")
    private String name;

    @NotEmpty
    @NotNull
    @Length(min = 11, max = 11, message = "The user cpf ")
    private String cpf;

    @NotEmpty(message = "The user email cannot be empty")
    @NotNull(message = "The user email cannot be null")
    private String email;

    @NotEmpty(message = "The user password cannot be empty")
    @NotNull(message = "The user password cannot be null")
    @Length(min = 6, message = "The user password ")
    private String password;
}
