package com.hotel.demo.repository;

import com.hotel.demo.model.ImageHome;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageHomeRepository extends PagingAndSortingRepository<ImageHome, Long> {
    Iterable<ImageHome> findAllByHome_Id(Long home_id);
}
