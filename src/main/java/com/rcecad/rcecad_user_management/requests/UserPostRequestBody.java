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

    @NotEmpty(message = "The username cannot be empty")
    @NotNull(message = "The username cannot be null")
    private String username;

    @NotEmpty(message = "The user email cannot be empty")
    @NotNull(message = "The user email cannot be null")
    private String email;

    @NotEmpty(message = "The user password cannot be empty")
    @NotNull(message = "The user password cannot be null")
    @Length(min = 6)
    private String password;
}
