package com.harsh.projects.urbanStayApp.service;

import com.harsh.projects.urbanStayApp.entity.Room;

import java.time.LocalDate;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteCurrentAndFutureInventories(Room room);
}
