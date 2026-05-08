package com.flix.identity.api;

import com.flix.common.dto.ApiResponse;
import com.flix.identity.dto.AuthResponse;
import com.flix.identity.dto.LoginRequest;
import com.flix.identity.dto.RegisterRequest;
import com.flix.identity.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/auth")
public class AuthController {

    AuthService authService;

    @PostMapping("/register/normal")
    public ApiResponse<AuthResponse> registerForNormalUser(@RequestBody @Valid RegisterRequest request) {
        var authResponse = authService.registerForNormalUser(request);
        return ApiResponse.success(authResponse);
    }

    @PostMapping("/register/vip")
    public ApiResponse<AuthResponse> registerForVipUser(@RequestBody @Valid RegisterRequest request) {
        var authResponse = authService.registerForVIPUser(request);
        return ApiResponse.success(authResponse);
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        var authResponse = authService.login(request);
        return ApiResponse.success(authResponse);
    }
}
