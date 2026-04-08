package com.harsh.projects.urbanStayApp.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HotelContactInfo {

    private String address;

    private String phoneNumber;

    private String location;

    private String email;
}
