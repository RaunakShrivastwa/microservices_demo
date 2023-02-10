package com.User.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private int id;
    private int hotelId;
    private int userId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
