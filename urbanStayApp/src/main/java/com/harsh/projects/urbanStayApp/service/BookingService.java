package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.dto.BookingDto;
import com.harsh.projects.urbanStayApp.dto.BookingRequest;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);
}
