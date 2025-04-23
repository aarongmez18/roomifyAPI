package com.back.roomify.service.room;

import com.back.roomify.domain.dtos.request.room.RoomCreateRequest;
import com.back.roomify.domain.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {

    Room createRoom(RoomCreateRequest request);
    List<Room> getPublicRooms();
    List<Room> getRoomsByCurrentUser();
    List<Room> getRoomsByFriends();
    Room getRoomById(Long roomId);
    List<Room> searchRoomsByName(String name);
}
