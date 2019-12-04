package com.hotel.demo.service.impl;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.model.Home;
import com.hotel.demo.model.StatusHome;
import com.hotel.demo.repository.HomeRepository;
import com.hotel.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        homeRepository.deleteById(id);
    }

    @Override
    public void save(Home home) {
        homeRepository.save(home);
    }

    @Override
    public Iterable<Home> findAllByCategoryHomeId(Long categoryHomeId) {
        return homeRepository.findAllByCategoryHomeId(categoryHomeId);
    }

    @Override
    public Iterable<Home> findAllByCategoryRoomId(Long id) {
        return homeRepository.findAllByCategoryRoomId(id);
    }

    @Override
    public Iterable<Home> findAllByStatusHomeId(Long statusHomeId) {
        return homeRepository.findAllByStatusHomeId(statusHomeId);
    }

    @Override
    public Iterable<Home> findHomeByAddressContaining(String address) {
        return homeRepository.findHomeByAddressContaining(address);
    }

    @Override
    public Iterable<Home> filterAll(Integer bedroomQuantity, Integer bathroomQuantity, String address, Double priceMin, Double priceMax) {

        if (bathroomQuantity == -1 && bedroomQuantity == -1) {
            return StreamSupport.stream(homeRepository.findAll().spliterator(), false)
                    .filter(h -> h.getAddress().toUpperCase().indexOf(address) > -1
                            && h.getPrice() >= priceMin && h.getPrice() <= priceMax).collect(Collectors.toList());

        }
        if (bathroomQuantity == -1) {
            return StreamSupport.stream(homeRepository.findAll().spliterator(), false)
                    .filter(h -> h.getAddress().toUpperCase().indexOf(address) > -1
                            && h.getBedroomQuantity() == bedroomQuantity
                            && h.getPrice() >= priceMin && h.getPrice() <= priceMax).collect(Collectors.toList());
        }
        if (bedroomQuantity == -1) {
            return StreamSupport.stream(homeRepository.findAll().spliterator(), false)
                    .filter(h -> h.getAddress().toUpperCase().indexOf(address) > -1
                            && h.getBathroomQuantity() == bathroomQuantity
                            && h.getPrice() >= priceMin && h.getPrice() <= priceMax).collect(Collectors.toList());

        }
        return StreamSupport.stream(homeRepository.findAll().spliterator(), false)
                .filter(h -> h.getAddress().toUpperCase().indexOf(address) > -1
                        && h.getBedroomQuantity() == bedroomQuantity
                        && h.getBathroomQuantity() == bathroomQuantity
                        && h.getPrice() >= priceMin && h.getPrice() <= priceMax).collect(Collectors.toList());

    }
}
