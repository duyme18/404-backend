package com.hotel.demo.repository;

import com.hotel.demo.model.StatusHome;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusHomeRepository extends PagingAndSortingRepository<StatusHome, Long> {
}
