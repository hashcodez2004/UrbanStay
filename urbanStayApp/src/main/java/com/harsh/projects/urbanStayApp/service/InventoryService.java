package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.HotelDto;
import com.harsh.projects.urbanStayApp.dto.HotelSearchRequest;
import com.harsh.projects.urbanStayApp.entity.Room;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteCurrentAndFutureInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
