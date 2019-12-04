package com.hotel.demo.controller;

import com.hotel.demo.model.CategoryRoom;
import com.hotel.demo.model.Home;
import com.hotel.demo.service.CategoryRoomService;
import com.hotel.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/category-room")
public class ApiCategoryRoomController {
    @Autowired
    private CategoryRoomService categoryRoomService;

    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<List<CategoryRoom>> findAllCategoryRoom() {
        List<CategoryRoom> categoryRooms = (List<CategoryRoom>) categoryRoomService.findAll();
        if (categoryRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryRooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryRoom> getIdCategoryRoom(@PathVariable Long id) {
        Optional<CategoryRoom> categoryHome = categoryRoomService.findById(id);
        if (categoryHome.isPresent()) {
            return new ResponseEntity<>(categoryHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<CategoryRoom> createCategoryRoom(@RequestBody CategoryRoom categoryRoom) {
        CategoryRoom categoryRoom1 = categoryRoom;
        categoryRoomService.save(categoryRoom);
        return new ResponseEntity<>(categoryRoom1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryRoom> updateCategoryRoom(@PathVariable Long id, @RequestBody CategoryRoom categoryRoom) {
        Optional<CategoryRoom> currentCategoryRoom = categoryRoomService.findById(id);
        if (!currentCategoryRoom.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCategoryRoom.get().setId(categoryRoom.getId());
        currentCategoryRoom.get().setName(categoryRoom.getName());
        categoryRoomService.save(currentCategoryRoom.get());
        return new ResponseEntity<>(currentCategoryRoom.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryRoom> deleteCategoryRoom(@PathVariable Long id) {
        Optional<CategoryRoom> categoryHome = categoryRoomService.findById(id);
        if (categoryHome.isPresent()) {
            categoryRoomService.remove(id);
            return new ResponseEntity<>(categoryHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<?> findAllHomeById(@PathVariable Long id) {
        List<Home> homes = (List<Home>) homeService.findAllByCategoryRoomId(id);
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
}
