package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.RoomDto;
import com.harsh.projects.urbanStayApp.entity.Hotel;
import com.harsh.projects.urbanStayApp.entity.Room;
import com.harsh.projects.urbanStayApp.exception.ResourceNotFoundException;
import com.harsh.projects.urbanStayApp.repository.HotelRepository;
import com.harsh.projects.urbanStayApp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating a new room in hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: "+hotelId));

        Room room = modelMapper.map(roomDto,Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

//        TODO: create Inventory as soon as room is created and if hotel is active

        return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting all rooms in hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: "+hotelId));

        return hotel.getRooms()
                .stream().
                map((element) -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomsById(Long roomId) {
        log.info("Getting the room with ID: {}", roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: "+roomId));

        return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public void deleteRoomsById(Long roomId) {
        log.info("Deleting the room with ID: {}", roomId);
        boolean exists = roomRepository.existsById(roomId);
        if(!exists){
            throw new ResourceNotFoundException("Room not found with ID: "+roomId);
        }
        roomRepository.deleteById(roomId);

//        TODO: delete all future inventories for this room
    }
}
