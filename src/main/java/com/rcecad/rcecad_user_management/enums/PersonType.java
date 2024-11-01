package com.rcecad.rcecad_user_management.enums;

import lombok.Getter;

@Getter
public enum PersonType {
    PERSONAL("Pessoa Física"), BUSINESS("Pessoa Jurídica");

    private final String value;

    PersonType(String value) {
        this.value = value;
    }
}
