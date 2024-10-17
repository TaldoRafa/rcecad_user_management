package com.rcecad.rcecad_user_management.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginPostRequestBody {
    @NotEmpty(message = "The email cannot be empty")
    @NotNull(message = "The email cannot be null")
    private String email;

    @NotEmpty(message = "The password cannot be empty")
    @NotNull(message = "The password cannot be null")
    private String password;
}
