package com.hotel.demo.repository;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.model.Home;
import com.hotel.demo.model.StatusHome;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HomeRepository extends PagingAndSortingRepository<Home, Long> {
    Iterable<Home> findAllByCategoryHome(CategoryHome categoryHome);

    Iterable<Home> findAllByCategoryRoom(CategoryRoom categoryRoom);

    Iterable<Home> findAllByStatusHome(StatusHome statusHome);
}
