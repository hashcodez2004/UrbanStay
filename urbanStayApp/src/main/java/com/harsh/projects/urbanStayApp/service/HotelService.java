package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.HotelDto;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long Id);
}
