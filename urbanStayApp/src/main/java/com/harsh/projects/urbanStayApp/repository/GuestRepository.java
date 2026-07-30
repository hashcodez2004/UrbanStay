package com.harsh.projects.urbanStayApp.repository;

import com.harsh.projects.urbanStayApp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
