package com.hotel.demo.controller;

import com.hotel.demo.model.CategoryHome;
import com.hotel.demo.service.CategoryHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/category-home")
public class ApiCategoryHomeController {
    @Autowired
    private CategoryHomeService categoryHomeService;

    @GetMapping
    public ResponseEntity<List<CategoryHome>> findAllCategoryHome(){
        List<CategoryHome> categoryHomes =(List<CategoryHome>) categoryHomeService.findAll();
        if(categoryHomes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categoryHomes,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryHome> getIdCategoryHome(@PathVariable Long id) {
        Optional<CategoryHome> categoryHome = categoryHomeService.findById(id);
        if (categoryHome.isPresent()) {
            return new ResponseEntity<>(categoryHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<CategoryHome> createBoard(@RequestBody CategoryHome categoryHome) {
        CategoryHome categoryHome1 = categoryHome;
        categoryHomeService.save(categoryHome);
        return new ResponseEntity<>(categoryHome1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryHome> updateBoard(@PathVariable Long id, @RequestBody CategoryHome categoryHome) {
        Optional<CategoryHome> currentCategoryHome = categoryHomeService.findById(id);
        if (!currentCategoryHome.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCategoryHome.get().setId(categoryHome.getId());
        currentCategoryHome.get().setName(categoryHome.getName());
        categoryHomeService.save(currentCategoryHome.get());
        return new ResponseEntity<>(currentCategoryHome.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryHome> deleteCategoryHome(@PathVariable Long id) {
        Optional<CategoryHome> categoryHome = categoryHomeService.findById(id);
        if (categoryHome.isPresent()) {
            categoryHomeService.remove(id);
            return new ResponseEntity<>(categoryHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
