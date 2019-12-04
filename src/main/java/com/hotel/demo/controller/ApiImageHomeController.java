package com.hotel.demo.controller;

import com.hotel.demo.model.Comment;
import com.hotel.demo.model.ImageHome;
import com.hotel.demo.service.ImageHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth/imageHome")
public class ApiImageHomeController {

    @Autowired
    private ImageHomeService imageHomeService;

    @GetMapping
    public ResponseEntity<?> findAllImage() {
        List<ImageHome> imageHomes = (List<ImageHome>) imageHomeService.findAll();
        if (imageHomes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIdImage(@PathVariable Long id) {
        Optional<ImageHome> imageHome = imageHomeService.findById(id);
        if (imageHome.isPresent()) {
            return new ResponseEntity<>(imageHome, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ImageHome> createImage(@RequestBody ImageHome imageHome) {
        ImageHome imageHome1 = imageHome;
        imageHomeService.save(imageHome);
        return new ResponseEntity<>(imageHome1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageHome> updateImage(@PathVariable Long id, @RequestBody ImageHome imageHome) {
        Optional<ImageHome> currentImage = imageHomeService.findById(id);
        if (!currentImage.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentImage.get().setId(imageHome.getId());
        currentImage.get().setPathFile(imageHome.getPathFile());
        imageHomeService.save(currentImage.get());
        return new ResponseEntity<>(currentImage.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImageHome> deleteImage(@PathVariable Long id) {
        Optional<ImageHome> imageHome = imageHomeService.findById(id);
        if (imageHome.isPresent()) {
            imageHomeService.remove(id);
            return new ResponseEntity<>(imageHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<?> findAllByHomeId(@PathVariable Long id) {
        List<ImageHome> imageHomes = (List<ImageHome>) imageHomeService.findAllByHome_Id(id);
        if (imageHomes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(imageHomes, HttpStatus.OK);
    }

}
