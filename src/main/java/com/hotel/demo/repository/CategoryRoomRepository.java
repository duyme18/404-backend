package com.hotel.demo.repository;

import com.hotel.demo.model.CategoryRoom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRoomRepository extends PagingAndSortingRepository<CategoryRoom, Long> {
}
