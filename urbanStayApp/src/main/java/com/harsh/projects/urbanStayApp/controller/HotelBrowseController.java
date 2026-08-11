package com.harsh.projects.urbanStayApp.controller;

import com.harsh.projects.urbanStayApp.dto.HotelDto;
import com.harsh.projects.urbanStayApp.dto.HotelInfoDto;
import com.harsh.projects.urbanStayApp.dto.HotelPriceDto;
import com.harsh.projects.urbanStayApp.dto.HotelSearchRequest;
import com.harsh.projects.urbanStayApp.service.HotelService;
import com.harsh.projects.urbanStayApp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelPriceDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest){

        var page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }
}