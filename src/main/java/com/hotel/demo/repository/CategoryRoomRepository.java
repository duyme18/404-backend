package com.hotel.demo.repository;

import com.hotel.demo.model.CategoryRoom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRoomRepository extends PagingAndSortingRepository<CategoryRoom, Long> {
    Iterable<CategoryRoom> findAllHomeById(Long id);
}
