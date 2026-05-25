package com.harsh.projects.urbanStayApp.repository;

import com.harsh.projects.urbanStayApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
