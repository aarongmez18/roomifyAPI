package com.back.roomify.controller;

import com.back.roomify.domain.dtos.request.room.RoomCreateRequest;
import com.back.roomify.domain.dtos.response.room.RoomCreateResponse;
import com.back.roomify.domain.entity.Room;
import com.back.roomify.service.room.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/room")
@RequiredArgsConstructor
@Tag(name = "Room resource")
public class RoomController {

    private final RoomService roomService;
    private final ConversionService conversionService;

    @PostMapping("/rooms")
    @Operation(summary = "Create room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room created by request body",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomCreateRequest.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request 400",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<RoomCreateResponse> createRoom(@RequestBody @Parameter(description = "Room base data", required = true) RoomCreateRequest request) {
        Room room = roomService.createRoom(request);
        RoomCreateResponse response = conversionService.convert(room, RoomCreateResponse.class);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<RoomCreateResponse>> getPublicRooms() {
        List<Room> rooms = roomService.getPublicRooms();
        List<RoomCreateResponse> response = new ArrayList<>();
        for (Room room : rooms) {
            RoomCreateResponse convert = conversionService.convert(room, RoomCreateResponse.class);
            response.add(convert);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/my")
    @Operation(summary = "List rooms created by the current user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of user-created rooms",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomCreateResponse.class)))
    })
    public ResponseEntity<List<RoomCreateResponse>> getMyRooms() {
        List<Room> rooms = roomService.getRoomsByCurrentUser();
        List<RoomCreateResponse> response = new ArrayList<>();
        for (Room room : rooms) {
            RoomCreateResponse convert = conversionService.convert(room, RoomCreateResponse.class);
            response.add(convert);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/friends")
    @Operation(summary = "List rooms created by friends")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of rooms from friends",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomCreateResponse.class)))
    })
    public ResponseEntity<List<RoomCreateResponse>> getFriendsRooms() {
        List<Room> rooms = roomService.getRoomsByFriends();
        List<RoomCreateResponse> response = new ArrayList<>();
        for (Room room : rooms) {
            RoomCreateResponse convert = conversionService.convert(room, RoomCreateResponse.class);
            response.add(convert);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/{roomId}")
    @Operation(summary = "Get room by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room details",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomCreateResponse.class))),
            @ApiResponse(responseCode = "404", description = "Room not found",
                    content = @Content)
    })
    public ResponseEntity<RoomCreateResponse> getRoomById(
            @Parameter(description = "ID of the room", required = true)
            @PathVariable Long roomId) {
        Room room = roomService.getRoomById(roomId);
        RoomCreateResponse response = conversionService.convert(room, RoomCreateResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/search")
    @Operation(summary = "Search rooms by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of matching rooms",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoomCreateResponse.class)))
    })
    public ResponseEntity<List<RoomCreateResponse>> searchRoomsByName(
            @Parameter(description = "Name or part of name to search for", required = true)
            @RequestParam String name) {
        List<Room> rooms = roomService.searchRoomsByName(name);
        List<RoomCreateResponse> response = new ArrayList<>();
        for (Room room : rooms) {
            RoomCreateResponse convert = conversionService.convert(room, RoomCreateResponse.class);
            response.add(convert);
        }
        return ResponseEntity.ok(response);
    }

}
