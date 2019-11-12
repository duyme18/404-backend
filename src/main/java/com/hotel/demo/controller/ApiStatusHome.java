package com.hotel.demo.controller;

import com.hotel.demo.model.StatusHome;
import com.hotel.demo.service.StatusHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/status-home")
public class ApiStatusHome {
    @Autowired
    private StatusHomeService statusHomeService;

    @GetMapping
    public ResponseEntity<List<StatusHome>> findAllStatusHome(){
        List<StatusHome> statuses =(List<StatusHome>) statusHomeService.findAll();
        if(statuses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(statuses,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StatusHome> getIdStatusHome(@PathVariable Long id) {
        Optional<StatusHome> statusHome = statusHomeService.findById(id);
        if (statusHome.isPresent()) {
            return new ResponseEntity<>(statusHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<StatusHome> createStatusHome(@RequestBody StatusHome statusHome) {
        StatusHome statusHome1 = statusHome;
        statusHomeService.save(statusHome);
        return new ResponseEntity<>(statusHome1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StatusHome> updateStatusHome(@PathVariable Long id, @RequestBody StatusHome statusHome) {
        Optional<StatusHome> currentStatusHome = statusHomeService.findById(id);
        if (!currentStatusHome.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentStatusHome.get().setId(statusHome.getId());
        currentStatusHome.get().setName(statusHome.getName());
        statusHomeService.save(currentStatusHome.get());
        return new ResponseEntity<>(currentStatusHome.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusHome> deleteStatusHome(@PathVariable Long id) {
        Optional<StatusHome> statusHome = statusHomeService.findById(id);
        if (statusHome.isPresent()) {
            statusHomeService.remove(id);
            return new ResponseEntity<>(statusHome.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
