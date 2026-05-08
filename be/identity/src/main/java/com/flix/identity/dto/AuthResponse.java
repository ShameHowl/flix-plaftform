package com.flix.identity.dto;

public record AuthResponse(
        String accessToken,
        long expiresIn
) {
}
