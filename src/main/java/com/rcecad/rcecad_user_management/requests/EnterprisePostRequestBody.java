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
public class EnterprisePostRequestBody {
    @NotEmpty(message = "The enterprise name cannot be empty")
    @NotNull(message = "The enterprise name cannot be null")
    @Schema(description = "This is the enterprise's name", example = "Rafael Roani Gonçalves")
    private String name;

    @NotEmpty(message = "The enterprise email cannot be empty")
    @NotNull(message = "The enterprise email cannot be null")
    private String email;

    @NotEmpty
    @NotNull
    @Length(min = 14, max = 14, message = "The enterprise cnpj ")
    private String cnpj;

    @NotEmpty(message = "The enterprise password cannot be empty")
    @NotNull(message = "The enterprise password cannot be null")
    @Length(min = 6, message = "The enterprise password")
    private String password;
}
