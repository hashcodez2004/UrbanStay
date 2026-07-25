package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.HotelDto;
import com.harsh.projects.urbanStayApp.dto.HotelSearchRequest;
import com.harsh.projects.urbanStayApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
