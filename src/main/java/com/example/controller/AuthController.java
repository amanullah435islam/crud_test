package com.example.controller;

import com.example.dto.request.DoctorRegistrationDTO;
import com.example.dto.request.ForgotPasswordRequestDTO;
import com.example.dto.request.LoginRequestDTO;
import com.example.dto.request.ResetPasswordRequestDTO;
import com.example.dto.response.LoginResponseDTO;
import com.example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

// // this code are email into token after Ragistration(professional way)

    @PostMapping("/doctor/register")
public ResponseEntity<?> registerDoctor(
        @RequestBody DoctorRegistrationDTO dto
){
    String token = authService.registerDoctor(dto);
    return ResponseEntity.ok(
            Map.of(
                    "message",
                    "Doctor registered successfully",

                    "verificationToken",
                    token
            )
    );

}

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }


    // GET /api/auth/verify-email?token=...
    // User clicks this link from their email
    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        authService.verifyEmail(token);
        return ResponseEntity.ok("Email verified successfully. You can now log in.");
    }

    // ── Password reset ──────────────────────────────────────────────

    // POST /api/auth/forgot-password
    // Body: { "email": "fatema@gmail.com" }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequestDTO dto) {
        authService.forgotPassword(dto);
        return ResponseEntity.ok("Password reset link sent to " + dto.getEmail());
    }

    // POST /api/auth/reset-password
    // Body: { "token": "...", "newPassword": "newPass123" }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestDTO dto) {
        authService.resetPassword(dto);
        return ResponseEntity.ok("Password reset successful. You can now log in with your new password.");
    }


}