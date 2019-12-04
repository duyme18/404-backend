package com.hotel.demo.repository;

import com.hotel.demo.model.Home;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends PagingAndSortingRepository<Home, Long> {
    Iterable<Home> findAllByCategoryHomeId(Long id);

    Iterable<Home> findAllByCategoryRoomId(Long id);

    Iterable<Home> findAllByStatusHomeId(Long id);

    Iterable<Home> findHomeByAddressContaining(String address);
}
