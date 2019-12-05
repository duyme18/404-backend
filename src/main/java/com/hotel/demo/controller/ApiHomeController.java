package com.hotel.demo.controller;

import com.hotel.demo.message.request.SearchByAddress;
import com.hotel.demo.model.Comment;
import com.hotel.demo.model.Home;
import com.hotel.demo.model.ImageHome;
import com.hotel.demo.service.CommentService;
import com.hotel.demo.service.HomeService;
import com.hotel.demo.service.ImageHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/home")
public class ApiHomeController {
    @Autowired
    private HomeService homeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageHomeService imageHomeService;

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
        homes = (List<Home>) homeService.findHomeByAddressContaining(searchByAddress.getAddress());
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @GetMapping("/searchAll/{bedroomQuantity}/{bathroomQuantity}/{address}/{priceMin}/{priceMax}")
    public ResponseEntity<?> searchAll(@PathVariable Integer bedroomQuantity,
                                       @PathVariable Integer bathroomQuantity,
                                       @PathVariable String address,
                                       @PathVariable Double priceMin,
                                       @PathVariable Double priceMax) {
        System.out.println(bedroomQuantity + " " + bathroomQuantity + " " + address + " " + priceMin + " " + priceMax);
        List<Home> homes;
        if (address.equals("-1"))
            homes = (List<Home>) homeService.filterAll(bedroomQuantity, bathroomQuantity, "", priceMin, priceMax);
        else
            homes = (List<Home>) homeService.filterAll(bedroomQuantity, bathroomQuantity, address.toUpperCase(), priceMin, priceMax);
        if (homes.isEmpty()) {
            return new ResponseEntity<>(homes, HttpStatus.OK);
        }
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
        currentHome.get().setLatitude(home.getLatitude());
        currentHome.get().setLongitude(home.getLongitude());
        currentHome.get().setDescription(home.getDescription());
        currentHome.get().setPrice(home.getPrice());
        currentHome.get().setFile(home.getFile());
        currentHome.get().setBathroomQuantity(home.getBathroomQuantity());
        currentHome.get().setBedroomQuantity(home.getBedroomQuantity());
        currentHome.get().setAddress(home.getAddress());
        currentHome.get().setName(home.getName());
        currentHome.get().setId(home.getId());
        currentHome.get().setBooking(home.getBooking());

        homeService.save(currentHome.get());
        return new ResponseEntity<>(currentHome.get(), HttpStatus.OK);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<?> findHomeByBookingId(@PathVariable Long id){
        List<Home> homes = (List<Home>) homeService.findAllByBooking_Id(id);
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHome(@PathVariable Long id) {
        List<Comment> comments = (List<Comment>) commentService.findCommentByHomeId(id);
        List<ImageHome> imageHomes = (List<ImageHome>) imageHomeService.findAllByHome_Id(id);
        Optional<Home> home = homeService.findById(id);
        if (!comments.isEmpty() && home.isPresent()) {
            for (Comment comment : comments) {
                commentService.remove(comment.getId());
            }
            homeService.remove(id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!imageHomes.isEmpty() && home.isPresent()) {
            for (ImageHome imageHome : imageHomes) {
                imageHomeService.remove(imageHome.getId());
            }
            homeService.remove(id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (home.isPresent()) {
            homeService.remove(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
