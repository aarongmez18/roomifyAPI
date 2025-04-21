package com.back.roomify.domain.entity;

import com.back.roomify.domain.enums.RoomStatus;
import com.back.roomify.domain.enums.RoomType;
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
@Schema(description = "Entity representing a chat or event room.")
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the room", example = "1")
    private Long id;

    @Schema(description = "Unique title of the room", example = "TechTalks 2025")
    private String title;

    @Schema(description = "Brief description of the room", example = "A place to discuss the latest in tech.")
    private String description;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Type of the room", example = "PUBLIC")
    private RoomType type; // PUBLIC, PRIVATE, THEMATIC

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @Schema(description = "Reference to the account that created the room")
    private Account creator;

    @Column(name = "created_at", nullable = false)
    @Schema(description = "Timestamp when the room was created", example = "2025-04-21T10:15:30")
    private LocalDateTime createdAt;

    @Column(name = "max_capacity", nullable = false)
    @Schema(description = "Maximum number of participants allowed", example = "100")
    private int maxCapacity;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Current status of the room", example = "ACTIVE")
    private RoomStatus status; // ACTIVE, ARCHIVED, DELETED

    @Schema(description = "Latitude coordinate of the room (for location-based features)", example = "37.7749")
    private double latitude;

    @Schema(description = "Longitude coordinate of the room (for location-based features)", example = "-122.4194")
    private double longitude;

    @Column(name = "expiration_date", nullable = false)
    @Schema(description = "Expiration date and time of the room", example = "2025-05-21T10:15:30")
    private LocalDateTime expirationDate;

    @Column(name = "room_picture", nullable = false)
    @Schema(description = "URL to the room's profile picture", example = "https://roomify.com/rooms/room123.jpg")
    private String roomPicture;
}
