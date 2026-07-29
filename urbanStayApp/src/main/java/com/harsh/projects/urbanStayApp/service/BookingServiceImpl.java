package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.BookingDto;
import com.harsh.projects.urbanStayApp.dto.BookingRequest;
import com.harsh.projects.urbanStayApp.entity.*;
import com.harsh.projects.urbanStayApp.enums.BookingStatus;
import com.harsh.projects.urbanStayApp.exception.ResourceNotFoundException;
import com.harsh.projects.urbanStayApp.repository.BookingRepository;
import com.harsh.projects.urbanStayApp.repository.HotelRepository;
import com.harsh.projects.urbanStayApp.repository.InventoryRepository;
import com.harsh.projects.urbanStayApp.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final InventoryRepository inventoryRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public BookingDto initialiseBooking(BookingRequest bookingRequest) {

        log.info("Initializing booking for hotel: {}, room: {}, date: {}--{}", bookingRequest.getHotelId(),
                bookingRequest.getRoomId(), bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate());

        Hotel hotel = hotelRepository.findById(bookingRequest.getHotelId()).orElseThrow(()->
                new ResourceNotFoundException("Hotel not found with id: "+bookingRequest.getHotelId()));

        Room room = roomRepository.findById(bookingRequest.getRoomId()).orElseThrow(()->
                new ResourceNotFoundException("Room not found with id: "+bookingRequest.getRoomId()));

        List<Inventory> inventoryList = inventoryRepository.findAndLockAvailableInventory(bookingRequest.getRoomId(),
                bookingRequest.getCheckInDate(), bookingRequest.getCheckOutDate(), bookingRequest.getRoomsCount());

        long daysCount = ChronoUnit.DAYS.between(bookingRequest.getCheckInDate(),bookingRequest.getCheckOutDate()) + 1;

        if(inventoryList.size() != daysCount){
            throw new IllegalStateException("Room is not available anymore");
        }

        //Reserve the room/ update the bookedCount for inventories
        for(Inventory inventory: inventoryList){
            inventory.setReservedCount(inventory.getReservedCount() + bookingRequest.getRoomsCount());
        }

        inventoryRepository.saveAll(inventoryList);

        //Create the booking

        User user = new User();
        user.setId(1L);    //TODO: REMOVE DUMMY USER

        //TODO: calculate dynamic amount

        Booking booking = Booking.builder()
                .bookingStatus(BookingStatus.RESERVED)
                .hotel(hotel)
                .room(room)
                .checkInDate(bookingRequest.getCheckInDate())
                .checkOutDate(bookingRequest.getCheckOutDate())
                .user(user)
                .roomsCount(bookingRequest.getRoomsCount())
                .amount(BigDecimal.TEN)
                .build();

        booking = bookingRepository.save(booking);
        return modelMapper.map(booking,BookingDto.class);
    }
}
