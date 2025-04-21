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
@Schema(description = "Entity representing a member inside a room.")
public class RoomMember {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the room member", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @Schema(description = "Reference to the room the member belongs to")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Schema(description = "Reference to the account of the member")
    private Account member;

    @Column(nullable = false)
    @Schema(description = "Role of the member in the room", example = "PARTICIPANT")
    private String role; // PARTICIPANT, MODERATOR, OWNER

    @Column(name = "joined_at", nullable = false)
    @Schema(description = "Timestamp of when the member joined the room", example = "2025-04-21T15:30:00")
    private LocalDateTime joinedAt;
}
