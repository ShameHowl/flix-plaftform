package com.flix.identity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthProvider {
    LOCAL,
    GOOGLE;

    public static AuthProvider from(String provider) {
        return valueOf(provider.toUpperCase());
    }
}
