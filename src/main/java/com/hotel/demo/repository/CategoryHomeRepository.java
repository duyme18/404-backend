package com.hotel.demo.repository;

import com.hotel.demo.model.CategoryHome;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryHomeRepository extends PagingAndSortingRepository<CategoryHome, Long> {
}
