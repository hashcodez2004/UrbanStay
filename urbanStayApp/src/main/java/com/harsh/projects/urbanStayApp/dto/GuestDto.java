package com.harsh.projects.urbanStayApp.dto;

import com.harsh.projects.urbanStayApp.entity.User;
import com.harsh.projects.urbanStayApp.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {

    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
