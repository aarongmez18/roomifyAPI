package com.back.roomify.controller.mapper.room;

import com.back.roomify.domain.dtos.response.room.RoomCreateResponse;
import com.back.roomify.domain.entity.Room;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface RoomToRoomCreateResponse extends Converter<Room, RoomCreateResponse> {

	@Override
	RoomCreateResponse convert(@NonNull Room source);

}
