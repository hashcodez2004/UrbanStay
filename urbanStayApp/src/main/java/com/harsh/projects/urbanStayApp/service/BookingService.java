package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.BookingDto;
import com.harsh.projects.urbanStayApp.dto.BookingRequest;
import com.harsh.projects.urbanStayApp.dto.GuestDto;
import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
