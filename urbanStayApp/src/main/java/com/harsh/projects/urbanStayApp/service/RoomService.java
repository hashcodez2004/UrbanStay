package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    RoomDto getRoomsById(Long roomId);

    void deleteRoomsById(Long roomId);
}
