package com.back.roomify.domain.entity;

import com.back.roomify.domain.enums.AccountGender;
import com.back.roomify.domain.enums.AccountRole;
import com.back.roomify.domain.enums.AccountStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity that represents a user account.")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the account", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Unique username", example = "aaron_dev")
    private String username;

    @Column(nullable = false)
    @Schema(description = "User's name", example = "Aaron")
    private String name;

    @Column(name = "last_name", nullable = false)
    @Schema(description = "User's last name", example = "Martinez Gomez")
    private String lastName;

    @Column(nullable = false)
    @Schema(description = "Unique email address", example = "aaron@example.com")
    private String email;

    @Column(nullable = false)
    @Schema(description = "Password hash (e.g., BCrypt)", example = "$2a$10$...")
    private String password;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Role of the account", example = "USER")
    private AccountRole role; // ADMIN, USER, ENTERPRISE

    @Column(name = "birth_date", nullable = false)
    @Schema(description = "Date of birth", example = "1995-04-21")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Gender of the user", example = "MALE")
    private AccountGender gender; // MALE , FEMALE , OTHER

    @Schema(description = "User's nationality", example = "Spanish")
    private String nationality;

    @Schema(description = "Country of residence", example = "Spain")
    private String country;

    @Schema(description = "City of residence", example = "Utrera")
    private String city;

    @Column(name = "postal_code")
    @Schema(description = "Postal code", example = "41710")
    private String postalCode;

    @Schema(description = "Phone number", example = "612345678")
    private int phone;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Date and time when the account was created", example = "2025-04-21T10:00:00")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status of the account (ACTIVE, SUSPENDED, DELETED)", example = "ACTIVE")
    private AccountStatus status; // ACTIVE, SUSPENDED, DELETED

}
