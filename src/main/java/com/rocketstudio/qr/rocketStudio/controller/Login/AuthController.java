package com.rocketstudio.qr.rocketStudio.controller.Login;

import com.rocketstudio.qr.rocketStudio.dto.LoginRequest;
import com.rocketstudio.qr.rocketStudio.dto.LoginResponse;
import com.rocketstudio.qr.rocketStudio.entity.User;
import com.rocketstudio.qr.rocketStudio.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout successful");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Validated @RequestBody LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            String role = userService.getRoleByRoleId(user.getRole());
            LoginResponse loginResponse = new LoginResponse("Login successful", role, user.getRole().getId());
            return ResponseEntity.ok(loginResponse);
        } else {
            LoginResponse loginResponse = new LoginResponse("Invalid credentials", null, null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }
}