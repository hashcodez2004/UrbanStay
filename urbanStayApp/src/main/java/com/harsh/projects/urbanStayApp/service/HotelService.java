package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.HotelDto;
import com.harsh.projects.urbanStayApp.dto.HotelInfoDto;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
