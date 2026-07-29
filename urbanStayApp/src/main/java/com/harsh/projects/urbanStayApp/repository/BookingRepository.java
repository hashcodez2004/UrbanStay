package com.harsh.projects.urbanStayApp.repository;

import com.harsh.projects.urbanStayApp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
