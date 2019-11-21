package com.hotel.demo.controller;

import com.hotel.demo.message.request.SearchByAddress;
import com.hotel.demo.model.Home;
import com.hotel.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/home")
public class ApiHomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<List<Home>> findAllHome() {
        List<Home> homes = (List<Home>) homeService.findAll();
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Home> getIdHome(@PathVariable Long id) {
        Optional<Home> home = homeService.findById(id);
        if (home.isPresent()) {
            return new ResponseEntity<>(home.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/searchByAddress")
    public ResponseEntity<?> searchHomeByAddress(@RequestBody SearchByAddress searchByAddress) {
        List<Home> homes;
        if (searchByAddress.getAddress() == "") {
            homes = (List<Home>) homeService.findAll();
            if (homes.isEmpty()) {
                return new ResponseEntity<>(homes, HttpStatus.OK);

            }
            return new ResponseEntity<>(homes, HttpStatus.OK);

        }
        homes = (List<Home>) homeService.findHomeByAddressContaining(searchByAddress.getAddress());
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Home> createHome(@RequestBody Home home) {

        homeService.save(home);
        return new ResponseEntity<>(home, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Home> updateHome(@PathVariable Long id, @RequestBody Home home) {
        Optional<Home> currentHome = homeService.findById(id);
        if (!currentHome.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentHome.get().setCategoryRoom(home.getCategoryRoom());
        currentHome.get().setCategoryHome(home.getCategoryHome());
        currentHome.get().setStatusHome(home.getStatusHome());
        currentHome.get().setDescription(home.getDescription());
        currentHome.get().setPrice(home.getPrice());
        currentHome.get().setFile(home.getFile());
        currentHome.get().setBathroomQuantity(home.getBathroomQuantity());
        currentHome.get().setBedroomQuantity(home.getBedroomQuantity());
        currentHome.get().setAddress(home.getAddress());
        currentHome.get().setName(home.getName());
        currentHome.get().setId(home.getId());

        homeService.save(currentHome.get());
        return new ResponseEntity<>(currentHome.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Home> deleteHome(@PathVariable Long id) {
        Optional<Home> home = homeService.findById(id);
        if (home.isPresent()) {
            homeService.remove(id);
            return new ResponseEntity<>(home.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
