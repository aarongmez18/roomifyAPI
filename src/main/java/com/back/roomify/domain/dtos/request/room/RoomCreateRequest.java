package com.back.roomify.domain.dtos.request.room;

import com.back.roomify.domain.enums.RoomType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for creating a new room")
public class RoomCreateRequest {


    @Schema(description = "Room title", example = "Meeting in the park today")
    private String title;

    @Schema(description = "Description for the room", example = "Meeting with my friends to be in the park relaxing")
    private String description;

    @Schema(description = "Type for the room", example = "PUBLIC")
    private RoomType type; // PUBLIC, PRIVATE, THEMATIC

    @Schema(description = "Max capacity for the room", example = "100")
    private int maxCapacity;

    @Schema(description = "URL to the room's profile picture", example = "https://roomify.com/rooms/room123.jpg")
    private String roomPicture;

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public int getMaxCapacity() {
        return maxCapacity;
    }

    public RoomType getType() {
        return type;
    }


    public String getRoomPicture() {
        return roomPicture;
    }

}
