package com.back.roomify.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity representing a user's access and refresh token.")
public class Token {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the token", example = "1")
    private Long id;

    @Column(name = "access_token", nullable = false)
    @Schema(description = "JWT access token for authentication", example = "eyJhbGciOiJIUz...")
    private String accessToken;

    @Column(name = "refresh_token", nullable = false)
    @Schema(description = "Refresh token used to renew the session", example = "d8f3a2ee-...")
    private String refreshToken;

    @Column(name = "is_logged")
    @Schema(description = "Indicates if the user is logged in via OAuth", example = "false")
    private boolean isLogged;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Schema(description = "Reference to the account associated with this token")
    private Account account;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Timestamp when the token was created", example = "2025-04-21T10:00:00")
    private LocalDateTime createdAt;

    @Column(name = "expires_at", nullable = false)
    @Schema(description = "Timestamp when the token expires", example = "2025-04-28T10:00:00")
    private LocalDateTime expiresAt;
}
