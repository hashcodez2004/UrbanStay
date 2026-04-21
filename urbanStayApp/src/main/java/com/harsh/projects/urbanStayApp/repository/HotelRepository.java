package com.harsh.projects.urbanStayApp.repository;

import com.harsh.projects.urbanStayApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
