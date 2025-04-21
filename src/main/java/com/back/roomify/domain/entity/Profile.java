package com.back.roomify.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entity representing a user profile with additional personal information.")
public class Profile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the profile", example = "1")
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    @Schema(description = "Reference to the associated account")
    private Account account;

    @Column(name = "profile_picture", nullable = false)
    @Schema(description = "URL to the user's profile picture", example = "https://roomify.com/images/profile123.jpg")
    private String profilePicture;

    @Schema(description = "Short biography or description of the user", example = "Full stack developer and tech enthusiast.")
    private String biography;
}
