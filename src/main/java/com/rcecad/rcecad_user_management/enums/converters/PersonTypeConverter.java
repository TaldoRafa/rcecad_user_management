package com.rcecad.rcecad_user_management.enums.converters;

import com.rcecad.rcecad_user_management.enums.PersonType;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class PersonTypeConverter implements AttributeConverter<PersonType, String> {
    @Override
    public String convertToDatabaseColumn(PersonType personType) {
        if (personType == null) return null;
        return personType.getValue();
    }

    @Override
    public PersonType convertToEntityAttribute(String value) {
        if (value == null) return null;

        return Stream.of(PersonType.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
