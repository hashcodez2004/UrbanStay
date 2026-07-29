package com.harsh.projects.urbanStayApp.dto;

import com.harsh.projects.urbanStayApp.entity.Hotel;
import com.harsh.projects.urbanStayApp.entity.Room;
import com.harsh.projects.urbanStayApp.entity.User;
import com.harsh.projects.urbanStayApp.enums.BookingStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {

    private Long id;
    private Integer roomsCount;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
}
