package com.back.roomify.service.room.impl;

import com.back.roomify.domain.dtos.request.room.RoomCreateRequest;
import com.back.roomify.domain.entity.Room;
import com.back.roomify.domain.enums.RoomStatus;
import com.back.roomify.domain.enums.RoomType;
import com.back.roomify.repository.RoomRepository;
import com.back.roomify.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;


    @Override
    public Room createRoom(RoomCreateRequest request) {

        Room room = new Room();
        room.setTitle(request.getTitle());
        room.setType(request.getType());
        room.setMaxCapacity(request.getMaxCapacity());
        room.setRoomPicture(request.getRoomPicture());
        room.setDescription(request.getDescription());

        // Cambiar cuando se añada Spring Security
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUsername = authentication.getName();
//        Account creator = accountRepository.findByUsername(currentUsername);
//        room.setCreator(creator);


        room.setCreatedAt(LocalDateTime.now());
        room.setStatus(RoomStatus.ACTIVE);
        room.setExpirationDate(room.getCreatedAt().plusDays(90));

        roomRepository.save(room);

        return room;
    }

    @Override
    public List<Room> getPublicRooms() {
        return roomRepository.findByType(RoomType.PUBLIC);
    }

    @Override
    public List<Room> getRoomsByCurrentUser() {
        return List.of();
    }

    @Override
    public List<Room> getRoomsByFriends() {
        return List.of();
    }

    @Override
    public Room getRoomById(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.orElseThrow(() -> new IllegalArgumentException("Room not found"));
    }

    @Override
    public List<Room> searchRoomsByName(String title) {

        return roomRepository.findByTitleContainingIgnoreCase(title);
    }

}
