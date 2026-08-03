package com.example.controller;

import com.example.dto.request.*;
import com.example.dto.response.LoginResponseDTO;
import com.example.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(
        name="Authentication APIs",
        description="Register, Login and JWT operations"
)
public class AuthController {

    private final AuthService authService;



    @PostMapping("/employee/register")
    @Operation(
            summary = "Register an Employee",
            description = "Creates a new employee account and sends an email verification link."
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Employee registered successfully"
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or email already exists"
            )

    })
    public ResponseEntity<?> registerEmployee(
            @RequestBody EmployeeRegistrationDTO dto
    ){
        String token = authService.registerEmployee(dto);
        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Employee registered successfully",

                        "verificationToken",
                        token
                )
        );

    }






    @PostMapping("/doctor/register")
    @Operation(
            summary = "Register a Doctor",
            description = "Creates a new user account with DOCTOR role and a doctor profile. A verification email is sent after successful registration."
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Doctor registered successfully"
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or email already exists"
            )

    })
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





    @PostMapping("/login")
    @Operation(
            summary = "User Login",
            description = "Authenticates the user and returns a JWT access token."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Login successful"
            ),

            @ApiResponse(
                    responseCode = "401",
                    description = "Invalid email or password"
            ),

            @ApiResponse(
                    responseCode = "403",
                    description = "Account is not verified or access is denied"
            )
    })
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }






    @GetMapping("/verify-email")
    @Operation(
            summary = "Verify Email",
            description = "Activates a user account using the email verification token."
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "200",
                    description = "Email verified successfully"
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid or expired verification token"
            )

    })
    public ResponseEntity<String> verifyEmail(

            @Parameter(
                    description = "Email verification token sent by email",
                    example = "eyJhbGciOiJIUzI1NiJ9..."
            )
            @RequestParam String token) {

        authService.verifyEmail(token);

        return ResponseEntity.ok(
                "Email verified successfully."
        );
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


// Just example not worked
    @GetMapping("/profile")
    public void profile(

            @Parameter(
                    description = "JWT Bearer Token"
            )

            @RequestHeader("Authorization")
            String token){



        return ;
    }
}
