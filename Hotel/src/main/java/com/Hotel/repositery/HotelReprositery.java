package com.Hotel.repositery;

import com.Hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelReprositery extends JpaRepository<Hotel,Integer> {
}
