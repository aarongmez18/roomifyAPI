package com.back.roomify.repository;

import com.back.roomify.domain.entity.Account;
import com.back.roomify.domain.entity.Room;
import com.back.roomify.domain.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByType(RoomType type);
    List<Room> findByCreator(Account creator);
    List<Room> findByCreatorIn(List<Account> friends);
    List<Room> findByTitleContainingIgnoreCase(String title);

}
