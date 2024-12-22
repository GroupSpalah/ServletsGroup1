package org.example.homeworks.hw_15_12_24;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Qualification {
    LOW,
    MEDIUM,
    HIGH
}
